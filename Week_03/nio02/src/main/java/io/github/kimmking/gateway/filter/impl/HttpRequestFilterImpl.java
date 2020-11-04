package io.github.kimmking.gateway.filter.impl;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author wangtf
 * @date 2020/11/5
 */
public class HttpRequestFilterImpl implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().add("nio", "cwangtf");
    }
}
