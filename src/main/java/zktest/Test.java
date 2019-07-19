package zktest;

import java.util.ArrayList;
import java.util.List;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;

public class Test {

	public static void main(String[] args) throws Exception {
		
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		String connectString = "127.0.0.1:2181";
//		CuratorFramework client = CuratorFrameworkFactory.newClient(connectString, retryPolicy);
		CuratorFramework client = CuratorFrameworkFactory.builder().connectString(connectString).retryPolicy(retryPolicy).sessionTimeoutMs(3000).build();
		client.start();
//		client.create().forPath("/myzk");
//		List<ACL> acls = new ArrayList<>();
//		ACL acl = new ACL();
//		acl.setId();
//		Acl
		client.create().withMode(CreateMode.EPHEMERAL)./*withACL(acls, true).*/forPath("/a", "abc".getBytes());
		
		String str = "持久化节点";
//		client.create().withMode(CreateMode.PERSISTENT).forPath("/myzk",str.getBytes());
//		client.create().withMode(CreateMode.PERSISTENT).forPath("/myzk/persistentnode");
//		
	}
}
