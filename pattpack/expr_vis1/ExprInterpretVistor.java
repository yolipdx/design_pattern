package pattpack.expr_vis1;

public class ExprInterpretVistor implements ExprVistor {
    @Override
    public int visit(Variable variable) {
        return variable.getValue();
    }

    @Override
    public int visit(Add expr) {
        return expr.getLeft().accept(this) + expr.getRight().accept(this);
    }

    @Override
    public int visit(Sub expr) {
        return expr.getLeft().accept(this) - expr.getRight().accept(this);
    }

    @Override
    public int visit(Mul expr) {
        return expr.getLeft().accept(this) * expr.getRight().accept(this);
    }

    @Override
    public int visit(Div expr) {
        return expr.getLeft().accept(this) / expr.getRight().accept(this);
    }

    @Override
    public int visit(Gt expr) {
        return  expr.getLeft().accept(this) > expr.getRight().accept(this) ?  1 : 0;
    }

    @Override
    public int visit(Lt expr) {
        return  expr.getLeft().accept(this) < expr.getRight().accept(this) ?  1 : 0;
    }
}
