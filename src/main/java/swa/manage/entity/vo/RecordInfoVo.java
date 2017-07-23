package swa.manage.entity.vo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import swa.manage.entity.RoomConfig;
import swa.manage.entity.RoomRecord;

import java.util.List;

/**
 * Created by jinyan on 7/23/17 10:20 PM.
 */
public class RecordInfoVo {
    private static final Logger logger = LoggerFactory.getLogger(RecordInfoVo.class);
    List<RoomRecord> roomRecords;
    RoomConfig roomConfig;

    public RecordInfoVo(RoomConfig roomConfig, List<RoomRecord> roomRecords) {
        this.roomRecords = roomRecords;
        this.roomConfig = roomConfig;
    }

    public List<RoomRecord> getRoomRecords() {
        return roomRecords;
    }

    public void setRoomRecords(List<RoomRecord> roomRecords) {
        this.roomRecords = roomRecords;
    }

    public RoomConfig getRoomConfig() {
        return roomConfig;
    }

    public void setRoomConfig(RoomConfig roomConfig) {
        this.roomConfig = roomConfig;
    }

    @Override
    public String toString() {
        return "RecordInfoVo{" +
                "roomRecords=" + roomRecords +
                ", roomConfig=" + roomConfig +
                '}';
    }
}
