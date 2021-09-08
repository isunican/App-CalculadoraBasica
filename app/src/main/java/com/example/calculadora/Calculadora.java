package com.example.calculadora;

public class Calculadora {

    double oper1;
    double oper2;
    OPERACION operacion;

    public enum OPERACION {
        SUMA("+"), RESTA("-"), MULT("*"), DIV( "/");

        private String symbol;

        private OPERACION(String symbol) {
            this.symbol = symbol;
        }

        public static OPERACION fromSymbol(String symbol) {
            for (OPERACION  o : OPERACION.values()) {
                if (o.symbol.equals(symbol)) {
                    return o;
                }
            }
            return null;
        }

        public double opera(double o1, double o2) {
            switch (this) {
                case SUMA: return o1+o2;
                case RESTA: return o1-o2;
                case MULT: return o1*o2;
                case DIV: return o1/o2;
                default: return 0d;
            }
        }
    };

    public void setOper1(double oper1) {
        this.oper1 = oper1;
    }

    public void setOper2(double oper2) {
        this.oper2 = oper2;
    }

    public void setOperacion(OPERACION operacion) {
        if (operacion != null) {
            this.operacion = operacion;
        }
    }

    public Calculadora() {
        oper1 = 0d;
        oper2 = 0d;
        operacion = OPERACION.SUMA;
    }

    public double opera() {
        return operacion.opera(oper1, oper2);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
