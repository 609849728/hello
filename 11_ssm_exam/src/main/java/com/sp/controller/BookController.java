package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.sp.entity.Book;
import com.sp.entity.User;
import com.sp.service.BookService;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/BookController")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;


    @RequestMapping("/getBookList")
    public String getBookList(Integer pageNum, Model model) {
        PageInfo pageInfo = bookService.getPageInfo(pageNum);

        model.addAttribute("page",pageInfo);
        model.addAttribute("pageUrl","BookController/getBookList?");

        return "bookList";
    }



    @RequestMapping("/getBookById/{id}")
    public String getBookById(@PathVariable Integer id,Model model) {
        Book book = bookService.getById(id);

        model.addAttribute("book",book);
        return "bookUpdate";
    }


    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        bookService.edit(book);

        return "redirect:/BookController/getBookList";
    }



    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id) {
        bookService.remove(id);

        return "redirect:/BookController/getBookList";
    }



    @RequestMapping("/addBook")
    public String addBook(Book book) {
        bookService.add(book);

        return "redirect:/BookController/getBookList";
    }


    //点击添加书籍，发送所有作者的姓名至添加页面
    @RequestMapping("/getAllUser")
    public String getAllUser(Model model) {
        List<User> list = userService.getAllUser();

        model.addAttribute("userList",list);
        return "bookAdd";
    }


}
