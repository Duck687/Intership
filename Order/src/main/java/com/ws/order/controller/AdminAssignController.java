package com.ws.order.controller;

import com.ws.order.models.AdministratorAssignments;
import com.ws.order.models.MasterAssignments;
import com.ws.order.models.Orders;
import com.ws.order.models.PartsList;
import com.ws.order.service.AdminAssignService;
import com.ws.order.service.MastersAssignService;
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
public class AdminAssignController {

        @Autowired
        private OrderService orderService;
        private AdminAssignService adminAssignService;
        private MastersAssignService mastersAssignService;
        private PartsListService partsListService;
         private static final Logger logger = LoggerFactory.getLogger(AdminAssignController.class);

        @GetMapping("")
        public List<Orders> getAllOrder() {
            return orderService.getAllOrder();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
            Orders account = orderService.getOrderById(id);
            if (account != null) {
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
                while(mastersAssignService.getMasterAssignmentsById(id)!= null)
                {
                    mastersAssignService.deleteMasterAssignments(id);
                }
                while(adminAssignService.getAdminAssigById(id)!= null)
                {
                    adminAssignService.deleteAdminAssig(id);
                }
            }
            catch(Exception e)
            {
              logger.info("Delete order: ", e);
            }
        }
        @PutMapping("/{id2}/master/")
        public void addMastertOrder(@PathVariable Long id2, @RequestBody Long id) {
            MasterAssignments master = new MasterAssignments(id2,id);
            mastersAssignService.saveOrUpdateMasterAssignments(master);
        }
        @PutMapping("/{id2}/admin/")
        public void addAdminOrder(@PathVariable Long id2, @RequestBody Long id) {
            AdministratorAssignments admin = new AdministratorAssignments(id2,id);
            adminAssignService.saveOrUpdateAdminAssig(admin);
        }
        @PutMapping("/{id2}/part/")
        public void addPartOrder(@PathVariable Long id2, @RequestBody Long id) {
            PartsList part = new PartsList(id2,id);
            partsListService.saveOrUpdatePartsList(part);
        }
        @DeleteMapping("/{id}/master/{id2}")
        public void deleteMasterOrder(@PathVariable Long id,@PathVariable Long id2)
        {
            mastersAssignService.deleteMasterAssignments(id2);
        }
        @DeleteMapping("/{id}/admin/{id2}")
        public void deleteAdminOrder(@PathVariable Long id,@PathVariable Long id2)
        {
            adminAssignService.deleteAdminAssig(id2);
        }
        @DeleteMapping("/{id}/part/{id2}")
        public void deletePartOrder(@PathVariable Long id,@PathVariable Long id2)
        {
            partsListService.deletePartsList(id2);
        }

}
