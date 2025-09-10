package zeus.test.concurrency.partition;

import zeus.concurrency.partition.GenericPartitionListThread;
import zeus.test.pojo.Employee;

import java.util.List;

/**
 * @Author: KG
 * @Description:
 * @Date: Created in 下午1:58 2018/1/24
 * @Modified by:
 */

public class EmployeePartitionListThread extends GenericPartitionListThread<Employee> {
    public EmployeePartitionListThread(int threadNum, List<Employee> dataList) {
        super(threadNum, dataList);
    }

    @Override
    public void callback(List<Employee> partitionList) {
        try {
            for (Employee employee:partitionList) {
                Thread.sleep(200);
                System.out.println(employee);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

