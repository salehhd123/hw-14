package com.example.hw14.Controller;

import com.example.hw14.ApiResponse.ApiResponse;
import com.example.hw14.Model.EmpModel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class EmpController {

    ArrayList<EmpModel> emp = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<EmpModel> get() {
        return emp;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid EmpModel e, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        emp.add(e);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

// update by index
//    @PutMapping("/update/{index}")
//    public ResponseEntity update(@PathVariable int index,@RequestBody @Valid EmpModel e,Errors errors){
//        if(errors.hasErrors()){
//            String message = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
//        }
//         emp.set(index,e);
//        return ResponseEntity.status(200).body(new ApiResponse("updated")); }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid EmpModel e,Errors errors) {
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i).getId().equals(id)) {
                emp.set(i, e);
                return ResponseEntity.status(200).body(new ApiResponse("updated"));
            } else if (errors.hasErrors()) {
                String message = errors.getFieldError().getDefaultMessage();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
            }

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity delete(@PathVariable int index){
        if (index<0 || index>emp.size()-1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("invalid index"));
        }
        emp.remove(index);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

    @PutMapping("/annual/{id}/{num}")
    public ResponseEntity annual( @PathVariable String id, @PathVariable int num) {
        for (EmpModel e : emp) {
            if (e.getId().equals(id)) {
                    if (e.getAnnualLeave() < num) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("you do not have enough annual days"));
                    }
                    e.setOnLeave(true);
                    int n = e.getAnnualLeave() - num;
                    e.setAnnualLeave(n);
                    return ResponseEntity.status(HttpStatus.OK).body(e);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("you enter a wrong id number"));
    }




    }
