package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.*;
import com.ccnu.xiahongyun.stmanagementsystem.query.CheckInEntity;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.RoomCheckInService;
import com.ccnu.xiahongyun.stmanagementsystem.services.UnCheckInService;
import com.ccnu.xiahongyun.stmanagementsystem.services.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uncheckin")
public class UnCheckInController {

    private final UnCheckInService unCheckInService;
    private final UserService userService;
    private final RoomCheckInService roomCheckInService;

    public UnCheckInController(UnCheckInService unCheckInService,UserService userService,RoomCheckInService roomCheckInService) {
        this.unCheckInService = unCheckInService;
        this.userService = userService;
        this.roomCheckInService =roomCheckInService;
    }



    @PostMapping("/query")
    public ResponseEntity<ResponseData> getRoom(@RequestBody RoomQuery roomQuery){
        List<Room> rooms;
        try {
            if(!StringUtils.isNotEmpty(roomQuery.getType()) && roomQuery.getTimeBegin() == null && roomQuery.getTimeEnd() == null){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data("查询条件不能为空").build());
            }
            rooms = unCheckInService.getRoomByQuery(roomQuery);
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(rooms).build());
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().buildFailureResponse());
        }
    }


}
