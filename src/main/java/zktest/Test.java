package zktest;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class Test {

	public static void main(String[] args) throws Exception {
		
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		String connectString = "127.0.0.1:2181";
		CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
		client.start();
//		client.create().forPath("/myzk");
		String str = "持久化节点";
//		client.create().withMode(CreateMode.PERSISTENT).forPath("/myzk",str.getBytes());
//		client.create().withMode(CreateMode.PERSISTENT).forPath("/myzk/persistentnode");
//		
	}
}
