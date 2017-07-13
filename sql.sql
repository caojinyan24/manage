CREATE TABLE `room_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `encode` varchar(8) NOT NULL DEFAULT '' COMMENT '编码:layer-pid',
  `layer` tinyint(4) unsigned NOT NULL COMMENT '所属层级',
  `pid` tinyint(4) unsigned NOT NULL COMMENT '层级编码:0,1,2',
  `room_name` varchar(32) NOT NULL COMMENT '展示名称',
  `p_pid` tinyint(4) unsigned NOT NULL COMMENT '所在上一层级编码',
  `isvalid` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '是否可用：0-不可用，1-可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='配置表';




INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('1-1,''1', '1', '北京', '0');
INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('1-2','1', '2', '成都', '0');
INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('2-1','2', '1', '互联网金融中心', '1');
INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('2-2','2', '2', '电子大厦', '1');
INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('3-1','3', '1', '17层', '1');
INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('3-2','3', '2', '24层', '1');
INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('4-1','4', '1', 'room1', '1');
INSERT INTO `room_config` (`encode`, `layer`, `pid`, `room_name`, `p_pid`) VALUES ('4-2','4', '2', 'room2', '1');


CREATE TABLE `room_record` (
  `id` bigint(24) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` date NOT NULL DEFAULT '1971-01-01' COMMENT '预定日期',
  `time_period` tinyint(4) NOT NULL DEFAULT '0' COMMENT '预定时间段，如0代表00:00-00:30，1代表00:30-1:00',
  `encode` varchar(8) NOT NULL DEFAULT '' COMMENT '编码:layer-pid',
  `staff_record_id` bigint(24) unsigned NOT NULL DEFAULT '0' COMMENT '人员预定表中关联id',
  `isvalid` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '是否已取消：0-取消，1-未取消',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_date_time_period_encode` (`date`,`time_period`,`encode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会议室预定记录表';


CREATE TABLE `staff_record` (
  `id` bigint(24) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` date NOT NULL DEFAULT '1971-01-01' COMMENT '预定日期',
  `start_time` time NOT NULL DEFAULT '00:00:00' COMMENT '预定开始时间',
  `end_time` time NOT NULL DEFAULT '00:00:00' COMMENT '预定结束时间',
  `encode` varchar(8) NOT NULL DEFAULT '' COMMENT '编码:layer-pid',
  `isvalid` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '是否已取消：0-取消，1-未取消',
  `staff_name` varchar(16) NOT NULL DEFAULT '' COMMENT '预订人姓名',
  `comment` varchar(1024) NOT NULL DEFAULT '' COMMENT '预定用途',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员预定记录表';
