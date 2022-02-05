package com.achui.community.controller;

import com.achui.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eurus.T
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {

    private AlphaService alphaService;

    @Autowired
    public void setAlphaService(AlphaService alphaService) {
        this.alphaService = alphaService;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String getData() {
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        //Get the request data, default request method: GET
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }

        System.out.println(request.getParameter("code"));

        //Return the response data
        response.setContentType("text/html;charset = utf-8");
        try {
            //Print the html
            PrintWriter writer = response.getWriter();
            writer.write("<h1>nowcoder</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //GET request

    /**
     * @param current 1
     * @param limit 20
     * @return String
     */
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current", required = false, defaultValue = "1") int current,
                              @RequestParam(name = "limit", required = false, defaultValue = "20") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    /**
     *
     * @param id studentId in path
     * @return String
     */
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudentById(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    //POST request

    /**
     *
     * @return success
     */
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "success!";
    }

    // Respond HTML data

    //sample 1
    /**
     *
     * @return ModelAndView
     */
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "Eurus");
        mav.addObject("age", 25);
        mav.setViewName("/demo/view");
        return mav;
    }

    //sample 2(recommended)

    /**
     *
     * @param model data
     * @return view path
     */
    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name", "University of Sheffield");
        model.addAttribute("age", "300 years");
        return "/demo/view";
    }

    //Respond JSON data (often used for asynchronous requests)
    //Java Objects => JSON String => Javascript Objects(cross-language situations)

    /**
     *
     * @return map
     */
    @RequestMapping(path = "/employee", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmployee() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Eurus");
        map.put("age", "25");
        map.put("salary", "11000");
        return map;
    }
}
