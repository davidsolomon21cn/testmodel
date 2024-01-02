package com.tencent.supersonic.headless.core.persistence.pojo;

import com.tencent.supersonic.headless.api.request.MetricQueryReq;
import com.tencent.supersonic.headless.api.request.ParseSqlReq;
import com.tencent.supersonic.headless.api.request.QueryStructReq;
import lombok.Data;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import org.apache.commons.lang3.tuple.Triple;

@Data
public class QueryStatement {

    private List<Long> modelIds;
    private String sql = "";
    private String sourceId = "";
    private String errMsg = "";
    private Boolean ok;
    private QueryStructReq queryStructReq;
    private MetricQueryReq metricReq;
    private ParseSqlReq parseSqlReq;
    private Integer status = 0;
    private Boolean isS2SQL = false;
    private List<ImmutablePair<String, String>> timeRanges;
    private Boolean enableOptimize = true;
    private Triple<String, String, String> minMaxTime;

    public boolean isOk() {
        this.ok = "".equals(errMsg) && !"".equals(sql);
        return ok;
    }

    public QueryStatement error(String msg) {
        this.setErrMsg(msg);
        return this;
    }
}