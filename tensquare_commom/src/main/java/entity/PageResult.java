package entity;

import java.util.List;

/**
 * @ClassName PageResult
 * @Author lish
 * @Date 2019/4/11 15:07
 * @description 分页返回结果类
 */
public class PageResult<T> {
    private Long total;     //总数
    private List<T> rows;   //分页数据

    public PageResult() {
    }

    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
