CREATE TABLE `room_config` (
  `id` bigint(16) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `city` VARCHAR (32)  NOT NULL DEFAULT '' COMMENT '所在城市',
  `region` VARCHAR (32)  NOT NULL DEFAULT '' COMMENT '所属区域',
  `layer` VARCHAR (32)  NOT NULL DEFAULT '' COMMENT  '所在楼层',
  `room_name` varchar(32) NOT NULL COMMENT '房间名称',
  `valid_status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '可用状态：0-不可用，1-可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='配置表';



INSERT INTO `user`.`room_config` ( `city`, `region`, `layer`, `room_name`, `valid_status`) VALUES ('北京', '互联网金融中心', '17', 'room1', '1');
INSERT INTO `user`.`room_config` (`city`, `region`, `layer`, `room_name`, `valid_status`) VALUES ('北京', '互联网金融中心', '24', 'room1', '1');
INSERT INTO `user`.`room_config` (`city`, `region`, `layer`, `room_name`, `valid_status`) VALUES ('北京', '互联网金融中心', '17', 'room2', '1');
INSERT INTO `user`.`room_config` (`city`, `region`, `layer`, `room_name`, `valid_status`) VALUES ('成都', '成都1', '16', 'room3', '1');


CREATE TABLE `room_record` (
  `id` bigint(24) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` date NOT NULL DEFAULT '1971-01-01' COMMENT '预定日期',
  `time_period` tinyint(4) NOT NULL DEFAULT '0' COMMENT '预定时间段，如0代表00:00-00:30，1代表00:30-1:00',
  `config_id` bigint(16) NOT NULL DEFAULT '0' COMMENT '配置表ID',
  `staff_record_id` bigint(24) unsigned NOT NULL DEFAULT '0' COMMENT '人员预定表中关联id',
  `valid_status` tinyint(4)  NOT NULL DEFAULT '1' COMMENT '可用状态：0-不可用，1-可用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_date_time_encode_period` (`date`,`time_period`,`encode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会议室预定记录表';


CREATE TABLE `staff_record` (
  `id` bigint(24) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `date` date NOT NULL DEFAULT '1971-01-01' COMMENT '预定日期',
  `reserve_time` varchar(64) NOT NULL DEFAULT '' COMMENT '预定时间',
  `config_id` bigint(16) NOT NULL DEFAULT '0' COMMENT '配置表ID',
  `valid_status` tinyint(4)  NOT NULL DEFAULT '1' COMMENT '可用：0-不可用，1-可用',
  `staff_name` varchar(16) NOT NULL DEFAULT '' COMMENT '预订人姓名',
  `staff_phone` varchar(16) NOT NULL DEFAULT '' COMMENT '预订人手机号',
  `comment` varchar(1024) NOT NULL DEFAULT '' COMMENT '预定用途',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员预定记录表';
