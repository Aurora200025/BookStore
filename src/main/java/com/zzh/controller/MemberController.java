package com.zzh.controller;

import com.zzh.entity.Evaluation;
import com.zzh.entity.Member;
import com.zzh.service.MemberService;
import com.zzh.service.exception.BusinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Aurora
 * @Date 2021/1/10 12:35
 * @Version 1.0
 * 会员控制器
 */
@Controller
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/register.html")
    public ModelAndView showRegister() {
        return new ModelAndView("/register");
    }

    @GetMapping("/login.html")
    public ModelAndView showLogin() {
        return new ModelAndView("/login");
    }

    @PostMapping("/registe")
    @ResponseBody
    public Map<String, String> register(String vc, String username, String password, String nickname, HttpServletRequest request) {

        //获取验证码
        String verfiyCode = (String) request.getSession().getAttribute("kaptchaVerifyCode");
        //比对是否正确
        Map<String, String> result = new HashMap<>();
        if (vc == null || verfiyCode == null || !vc.equalsIgnoreCase(verfiyCode)) {
            result.put("code", "VC01");
            result.put("msg", "验证码错误");
        } else {
            try {
                memberService.createMember(username, password, nickname);
                result.put("code", "0");
                result.put("msg", "success");
            } catch (BusinessException e) {
                e.printStackTrace();
                result.put("code", e.getCode());
                result.put("msg", e.getMsg());
            }
        }
        return result;
    }

    @PostMapping("/check_login")
    @ResponseBody
    public Map<String, String> checkLogin(String username, String password, String vc, HttpSession session) {
        //获取验证码
        String verfiyCode = (String) session.getAttribute("kaptchaVerifyCode");
        //比对是否正确
        Map<String, String> result = new HashMap<>();
        if (vc == null || verfiyCode == null || !vc.equalsIgnoreCase(verfiyCode)) {
            result.put("code", "VC01");
            result.put("msg", "验证码错误");
        }else {
            try {
                Member member = memberService.checkLogin(username, password);
                session.setAttribute("loginMember", member);
                result.put("code", "0");
                result.put("msg", "success");
            } catch (BusinessException e) {
                e.printStackTrace();
                result.put("code", e.getCode());
                result.put("msg", e.getMsg());
            }
        }
        return result;
    }

    @PostMapping("/update_read_state")
    @ResponseBody
    public Map<String, String> updateReadState(Long memberId, Long bookId, Integer readState) {
        Map<String, String> result = new HashMap<>();
        try {
            memberService.updateMemberReadState(memberId, bookId, readState);
            result.put("code", "0");
            result.put("msg", "success");
        } catch (BusinessException e) {
            e.printStackTrace();
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
        }
        return result;
    }

    @PostMapping("/evaluate")
    @ResponseBody
    public Map<String,Object> evaluate(Long memberId, Long bookId, Integer score, String content) {
        Map<String, Object> result = new HashMap<>();
        try {
            Evaluation evaluation = memberService.evaluate(memberId, bookId, score, content);
            result.put("code", "0");
            result.put("msg", "success");
            result.put("evaluation", evaluation);
        } catch (BusinessException e) {
            e.printStackTrace();
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
        }
        return result;
    }

    @PostMapping("/enjoy")
    @ResponseBody
    public Map<String,Object> enjoy(Long evaluationId) {
        Map<String, Object> result = new HashMap<>();
        try {
            Evaluation evaluation = memberService.enjoy(evaluationId);
            result.put("code", "0");
            result.put("msg", "success");
            result.put("evaluation", evaluation);
        } catch (BusinessException e) {
            e.printStackTrace();
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
        }
        return result;
    }
}
