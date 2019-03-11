package com.lattice.latticeuser.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lattice.latticeuser.dto.UserDTO;
import com.lattice.latticeuser.entity.User;
import com.lattice.latticeuser.entity.UserExample;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    User selectByPrimaryKey(Integer userid);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table tb_user
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(User record);

	int delete(Integer id);

	UserDTO getAll(String openid);
}