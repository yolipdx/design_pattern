package pattpack.ast_vis1;

import pattpack.expr_vis1.Expr;

public class InterpretVistor implements Visitor {
    @Override
    public Object visit(Assignment s, Object o) {
        s.getLvalue().setValue(s.getRvalue().eval());
        return s.getLvalue().eval();
    }

    @Override
    public Object visit(Compound s, Object o) {
        Statement[] body = s.getBody();
        for (Statement stmt : body) {
            stmt.accept(this, null);
        }
        return null;
    }

    @Override
    public Object visit(Conditional s, Object o) {
        Expr test = s.getTest();
        if (1 == test.eval()) s.getThenClause().accept(this, null);
        else                  s.getElseClause().accept(this, null);

        return null;
    }

    @Override
    public Object visit(Output s, Object o) {
        System.out.println(s.getExpr().eval());
        return null;
    }

    @Override
    public Object visit(While s, Object o) {
        Expr test = s.getTest();
        Statement body = s.getBody();
        while (1 == test.eval()) {
            body.accept(this, null);
        }

        return null;
    }
}
