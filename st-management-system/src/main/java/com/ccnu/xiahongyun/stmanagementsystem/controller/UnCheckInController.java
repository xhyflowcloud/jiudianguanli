package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.ResponseData;
import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.model.RoomCheckIn;
import com.ccnu.xiahongyun.stmanagementsystem.model.User;
import com.ccnu.xiahongyun.stmanagementsystem.query.CheckInEntity;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
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

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/uncheckin")
public class UnCheckInController {

    private final UnCheckInService unCheckInService;
    private final UserService userService;
    private final RoomCheckInService roomCheckInService;

    public UnCheckInController(UnCheckInService unCheckInService, UserService userService, RoomCheckInService roomCheckInService) {
        this.unCheckInService = unCheckInService;
        this.userService = userService;
        this.roomCheckInService = roomCheckInService;
    }

    @PostMapping("/query")
    public ResponseEntity<ResponseData> getRoom(@RequestBody RoomQuery roomQuery){
        List<Room> rooms;
        try {
            if(!StringUtils.isNotEmpty(roomQuery.getType()) && roomQuery.getTimeBegin() == null && roomQuery.getTimeEnd() == null){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data("查询条件不能为空").build());
            }
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(unCheckInService.getRoomByQuery(roomQuery)).build());
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().buildFailureResponse());
        }
    }

    @PostMapping("/checkin")
    public ResponseEntity<ResponseData> checkIn(@RequestBody CheckInEntity checkInEntity){

        try {
            User user = new User(checkInEntity.getUserName(), checkInEntity.getUserIDNum(), checkInEntity.getPhone());
            userService.insertUsers(user);
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
            checkInEntity.setTimeBegin(time.parse(time.format(checkInEntity.getTimeBegin())));
            checkInEntity.setTimeEnd(time.parse(time.format(checkInEntity.getTimeEnd())));
            RoomCheckIn roomCheckIn = new RoomCheckIn(null, checkInEntity.getTimeBegin(), checkInEntity.getTimeEnd(), checkInEntity.getUserId(), checkInEntity.getRoomId(), checkInEntity.getSwimming(), checkInEntity.getGym(), checkInEntity.getTotPrice() > 1000 ? true : false, checkInEntity.getTotPrice());
            roomCheckInService.insertRoomCheckIn(roomCheckIn);
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data("提交成功").build());
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().buildFailureResponse());
        }
    }
}
