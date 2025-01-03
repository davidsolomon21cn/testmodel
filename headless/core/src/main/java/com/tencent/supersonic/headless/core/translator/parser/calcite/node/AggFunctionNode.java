package com.tencent.supersonic.headless.core.translator.parser.calcite.node;

import com.tencent.supersonic.common.pojo.enums.EngineType;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.validate.SqlValidatorScope;

import java.util.Objects;

public class AggFunctionNode extends SemanticNode {

    public static SqlNode build(String agg, String name, SqlValidatorScope scope,
            EngineType engineType) throws Exception {
        if (Objects.isNull(agg) || agg.isEmpty()) {
            return parse(name, scope, engineType);
        }
        if (AggFunction.COUNT_DISTINCT.name().equalsIgnoreCase(agg)) {
            return parse(AggFunction.COUNT.name() + " ( " + AggFunction.DISTINCT.name() + " " + name
                    + " ) ", scope, engineType);
        }
        return parse(agg + " ( " + name + " ) ", scope, engineType);
    }

    public static enum AggFunction {
        AVG, COUNT_DISTINCT, MAX, MIN, SUM, COUNT, DISTINCT
    }
}
