package swa.manage.mapper.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import swa.manage.value.TimePeriodEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jinyan on 7/17/17 5:25 PM.
 */
public class TimePeriodEnumHandler extends BaseTypeHandler<TimePeriodEnum> {


    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, TimePeriodEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public TimePeriodEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return TimePeriodEnum.toEnum(rs.getInt(columnName));
    }

    @Override
    public TimePeriodEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return TimePeriodEnum.toEnum(rs.getInt(columnIndex));
    }

    @Override
    public TimePeriodEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return TimePeriodEnum.toEnum(cs.getInt(columnIndex));
    }
}
