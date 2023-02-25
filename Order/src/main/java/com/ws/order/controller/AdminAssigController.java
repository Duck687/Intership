package com.ws.order.controller;

import com.ws.order.models.AdministratorAssignments;
import com.ws.order.models.MasterAssignments;
import com.ws.order.models.Orders;
import com.ws.order.models.PartsList;
import com.ws.order.service.AdminAssigService;
import com.ws.order.service.MastersAssigService;
import com.ws.order.service.OrderService;
import com.ws.order.service.PartsListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Order")
public class AdminAssigController {

        @Autowired
        private OrderService orderService;
        private AdminAssigService adminAssigService;
        private MastersAssigService mastersAssigService;
        private PartsListService partsListService;
         private static final Logger logger = LoggerFactory.getLogger(AdminAssigController.class);

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
            orderService.saveOrUpdateOrder(account);
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
              logger.info("Delete order: ", e);
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
