package com.ws.Order.controller;

import com.ws.Order.models.AdministratorAssignments;
import com.ws.Order.models.MasterAssignments;
import com.ws.Order.models.Orders;
import com.ws.Order.models.PartsList;
import com.ws.Order.service.AdminAssigService;
import com.ws.Order.service.MastersAssigService;
import com.ws.Order.service.OrderService;
import com.ws.Order.service.PartsListService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
@RestController
@RequestMapping("/api/Order")
public class AdminAssigController {

        @Autowired
        private OrderService orderService;
        private AdminAssigService adminAssigService;
        private MastersAssigService mastersAssigService;
        private PartsListService partsListService;

        @GetMapping("")
        public List<Orders> getAllOrder() {
            return orderService.getAllOrder();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
            Orders account = orderService.getOrderById(id);
            if (account != null) {
                return new ResponseEntity<>(account, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("")
        public void createOrder(@RequestBody Orders account) {

            orderService.saveOrUpdateOrder(account);
        }

        @PutMapping("/{id}")
        public void updateOrder(@PathVariable Long id, @RequestBody Orders account) {
            MastersAssigService master = new MastersAssigService();
        }

        @DeleteMapping("/{id}")
        public void deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
            try
            {
                while(mastersAssigService.getMasterAssignmentsById(id)!= null)
                {
                    mastersAssigService.deleteMasterAssignments(id);
                }
                while(adminAssigService.getAdminiAssigById(id)!= null)
                {
                    adminAssigService.deleteAdminAssig(id);
                }
            }
            catch(Exception e)
            {

            }
        }
        @PutMapping("/{id}/addmaster/")
        public void addMastertOrder(@PathVariable Long id, @RequestBody Long id2) {
            MasterAssignments master = new MasterAssignments(id,id2);
            mastersAssigService.saveOrUpdateMasterAssignments(master);
        }
        @PutMapping("/{id}/addadmin/")
        public void addAdminOrder(@PathVariable Long id, @RequestBody Long id2) {
            AdministratorAssignments admin = new AdministratorAssignments(id,id2);
            adminAssigService.saveOrUpdateAdminAssig(admin);
        }
        @PutMapping("/{id}/addpart/")
        public void addPartOrder(@PathVariable Long id, @RequestBody Long id2) {
            PartsList part = new PartsList(id,id2);
            partsListService.saveOrUpdatePartsList(part);
        }

}
