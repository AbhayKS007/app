package com.guestbook.app.controller;

import com.guestbook.app.entity.Guest;
import com.guestbook.app.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("bookservice")
public class GuestBookController {

    @Autowired
    private IBookService service;

    @GetMapping("admin")
    public ResponseEntity<List<Guest>> getBooks( @RequestParam("role") String role,  @RequestParam("pass") String pass) {

        if(role.equals("admin") && pass.equals("pass")) {
            List<Guest> guests = service.getBooks();
            return new ResponseEntity<List<Guest>>(guests, HttpStatus.OK);
        }else{
            List<Guest> guests = null;
            return new ResponseEntity<List<Guest>>(guests, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("admin/{id}")
    public ResponseEntity<Guest> getBook(@PathVariable("id") Integer id) {
        Guest book = service.getBook(id);
        return new ResponseEntity<Guest>(book, HttpStatus.OK);
    }

    @PostMapping("admin/{id}")
    public ResponseEntity<String> setApproval(@PathVariable("id") Integer id, @RequestParam("value") String value) {
        if(value.equals("yes")) {
            Guest book = service.setApproval(id, value);
            String responseContent = "Guest request approved successfully";
            return new ResponseEntity<String>(responseContent, HttpStatus.OK);
        }else if(value.equals("no")){
            boolean isDeleted = service.deleteBook(id);
            if (isDeleted) {
                String responseContent = "Guest has been deleted successfully";
                return new ResponseEntity<String>(responseContent, HttpStatus.OK);
            }
            String error = "Error while deleting book from database";
            return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }else {
            String error = "Error while deleting book from database";
            return new ResponseEntity<String>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("guest")
    public ResponseEntity<Guest> createBook(@RequestBody Guest book, @RequestParam("role") String role) {
        if(role.equals("guest") || role.equals("admin")) {
            Guest b = service.createBook(book);
            return new ResponseEntity<Guest>(b, HttpStatus.OK);
        }else{
            Guest b = null;
            return new ResponseEntity<Guest>(b, HttpStatus.NOT_FOUND);
        }

    }

}

