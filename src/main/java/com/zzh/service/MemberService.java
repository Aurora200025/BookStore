package com.zzh.service;

import com.zzh.entity.Evaluation;
import com.zzh.entity.Member;
import com.zzh.entity.MemberReadState;

/**
 * @Author Aurora
 * @Date 2021/1/10 12:56
 * @Version 1.0
 * 会员注册
 */
public interface MemberService {
    /**
     * 注册新会员
     * @param username 用户名
     * @param password 密码
     * @param nickname 昵称
     * @return member对象
     */
    Member createMember(String username, String password, String nickname);

    /**
     * 登录验证
     * @param username 登录用户名
     * @param password 登录密码
     * @return 登录对象
     */
    Member checkLogin(String username, String password);

    /**
     * 查找会员对某一本书的阅读状态
     * @param memberId 会员id
     * @param bookId 书id
     * @return 返回会员状态
     */
    MemberReadState selectMemberReadState(Long memberId, Long bookId);

    /**
     * 更新阅读状态
     *
     * @param memberId  会员编号
     * @param bookId    图书编号
     * @param readState 阅读状态
     * @return 阅读状态对象
     */
    MemberReadState updateMemberReadState(Long memberId, Long bookId, Integer readState);

    /**
     * 发布新的短评功能
     * @param memberId 会员id
     * @param bookId 图书id
     * @param score 评分
     * @param content 短评内容
     * @return 短评对象
     */
    Evaluation evaluate(Long memberId, Long bookId, Integer score, String content);

    /**
     * 评分功能
     * @param evaluationId 短评id
     * @return 短评对象
     */
    Evaluation enjoy(Long evaluationId);
}
