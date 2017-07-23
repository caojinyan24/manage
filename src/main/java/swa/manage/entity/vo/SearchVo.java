package swa.manage.entity.vo;

import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jinyan on 7/23/17 11:05 PM.
 */
public class SearchVo {
    private static final Logger logger = LoggerFactory.getLogger(SearchVo.class);
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date = DateUtils.truncate(new Date(), Calendar.DATE);
    private String city = "北京";
    private String region = "";

    public SearchVo() {
    }

    public SearchVo(Date date) {
        this.date = date;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        if ("null".equals(this.city)) {
            this.city = null;
        }
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        if ("null".equals(this.region)) {
            this.region = null;
        }
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "SearchVo{" +
                "date=" + date +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
