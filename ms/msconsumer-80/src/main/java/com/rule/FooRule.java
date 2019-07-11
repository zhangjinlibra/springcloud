
package com.rule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class FooRule extends AbstractLoadBalancerRule
{

    private int serverIndex = 0;
    private int calledCount = 0;

    public Server choose(ILoadBalancer lb, Object key)
    {
        if (lb == null)
        {
            return null;
        }

        Server server = null;
        while (server == null)
        {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0))
            {
                return null;
            }

            if (calledCount < 5)
            {
                server = reachableServers.get(serverIndex);
                calledCount++;
            }
            else
            {
                calledCount = 0;
                serverIndex++;
                if (serverIndex >= serverCount)
                {
                    serverIndex = 0;
                }
            }

            if (server == null)
            {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe()))
            {
                return (server);
            }

            // Next.
            server = null;
        }
        return server;
    }

    @ Override
    public Server choose(Object key)
    {
        return choose(getLoadBalancer(), key);
    }

    @ Override
    public void initWithNiwsConfig(IClientConfig clientConfig)
    {
        // TODO Auto-generated method stub

    }

}
