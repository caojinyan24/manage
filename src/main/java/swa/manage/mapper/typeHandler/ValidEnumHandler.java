package swa.manage.mapper.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import swa.manage.value.ValidEnum;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jinyan on 7/17/17 4:08 PM.
 */
public class ValidEnumHandler extends BaseTypeHandler<ValidEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ValidEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public ValidEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return ValidEnum.toEnum(rs.getInt(columnName));
    }

    @Override
    public ValidEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return ValidEnum.toEnum(rs.getInt(columnIndex));
    }

    @Override
    public ValidEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return ValidEnum.toEnum(cs.getInt(columnIndex));
    }
}
