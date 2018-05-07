package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RoomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.ResponseData;
import com.ccnu.xiahongyun.stmanagementsystem.model.Room;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.RoomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.UnCheckInService;
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

    public UnCheckInController(UnCheckInService unCheckInService) {
        this.unCheckInService = unCheckInService;
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
}
