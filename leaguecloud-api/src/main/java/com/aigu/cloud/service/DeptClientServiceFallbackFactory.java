package com.aigu.cloud.service;

import com.aigu.cloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 此为服务降级 在客户端
 * （leaguecloud-consumer-dept-feign  下的yml  开启支持服务降级）
 *
 *
 *
 * 服务熔断 和 服务降级比较
 *
 *
 * 第一点：
 *          服务熔断在服务端
 *          服务降级在客户端
 * 第二点：
 *          服务熔断 ： 注重于调用服务出现错误  返回fallback  解决服务扇形调用引起的服务雪崩；
 *          服务降级 ： 着重于 在某些情况下 比如服务器资源紧张 舍弃某些服务情况下（丢车保帅）
 *                      在客户端访问舍弃的服务（宕机）发现不可用时候  返回预设好的值（比如：服务升级,请稍后访问）
 */

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setName("服务降级处理").setDb_source("no mysql");
//
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
