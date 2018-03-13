package pattpack.expr_vis1;

public interface ExprVistor {
    int visit(Variable variable);
    int visit(Add expr);
    int visit(Sub expr);
    int visit(Mul expr);
    int visit(Div expr);
    int visit(Gt expr);
    int visit(Lt expr);
}
