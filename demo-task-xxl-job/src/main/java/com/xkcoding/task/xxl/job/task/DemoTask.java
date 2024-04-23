package com.xkcoding.task.xxl.job.task;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.xxl.job.core.biz.model.ReturnT.FAIL;
import static com.xxl.job.core.biz.model.ReturnT.SUCCESS;

/**
 * <p>
 * 测试定时任务
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-07 10:15
 */
@Slf4j
@Component
public class DemoTask{

    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler() {
        // 可以动态获取传递过来的参数，根据参数不同，当前调度的任务不同
      String jobParam = XxlJobHelper.getJobParam();log.info("【param】= {}", jobParam);
        log.info("demo task run at : {}", DateUtil.now());
        return RandomUtil.randomInt(1, 11) % 2 == 0 ? SUCCESS : FAIL;
    }
}
