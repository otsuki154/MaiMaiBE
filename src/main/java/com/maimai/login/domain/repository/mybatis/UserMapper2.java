package com.maimai.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.maimai.login.domain.model.User;

@Mapper
public interface UserMapper2 {

    // 登録用メソッド
    public boolean insert(User user);

    // カウント用メソッド
    public int count();

    // １件検索用メソッド
    public User selectOne(String userId);

    // 全件検索用メソッド
    public List<User> selectMany();

    // １件更新用メソッド
    public boolean updateOne(User user);

    // １件削除用メソッド
    public boolean deleteOne(String userId);
}
