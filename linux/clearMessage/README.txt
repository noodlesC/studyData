clearMessage.zip
提供时间：20170330  脚本作者：翁力帆，张雷
Linux操作系统messages日志写满磁盘解决办法：

1. 将clearMessage.tar.gz包上传到Linux
2. 解压clearMessage.tar.gz包
3. 修改NODES文件，填写集群中所有机器IP地址，每行一个
4. 执行sh install.sh

PS:该脚本只需要在集群中任意一台节点上执行即可，不需要每台执行，但执行脚本的节点要能ssh到NODES文件里配置的其他节点；脚本执行依赖Linux crond 服务，不要关闭这个服务