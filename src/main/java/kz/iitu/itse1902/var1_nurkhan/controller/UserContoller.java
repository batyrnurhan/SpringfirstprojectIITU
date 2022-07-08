package kz.iitu.itse1902.var1_nurkhan.controller;

import kz.iitu.itse1902.var1_nurkhan.exception.NotFoundException;
import kz.iitu.itse1902.var1_nurkhan.model.Book;
import kz.iitu.itse1902.var1_nurkhan.model.User;
import kz.iitu.itse1902.var1_nurkhan.repository.BookRepository;
import kz.iitu.itse1902.var1_nurkhan.repository.UserRepository;
import kz.iitu.itse1902.var1_nurkhan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserContoller {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserService userService;

    //all books
    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //book by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) throws NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()->
                new NotFoundException("Book not found by this id::" +userId));
        return ResponseEntity.ok().body(user);
    }

    //create book
    @PostMapping("/")
    public User createUser(@RequestBody User user){
        return this.userRepository.save(user);
    }

    //update book
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User userDetails,
                                           Long bookId) throws NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()->
                new NotFoundException("User nnot found by this id::" +userId));
        Book book = bookRepository.findById(bookId).orElseThrow(()->
                new NotFoundException("Book nnot found by this id::" +bookId));

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setPassword(userDetails.getPassword());

        return ResponseEntity.ok(this.userRepository.save(user));
    }
    //delete book
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws NotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()->
                new NotFoundException("Book nnot found by this id::" +userId));
        this.userRepository.delete(user);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
