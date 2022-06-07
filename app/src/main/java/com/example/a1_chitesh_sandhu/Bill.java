package com.example.a1_chitesh_sandhu;

public class Bill {
    //properties of bill
    private double morningUsage;
    private double eveningUsage;
    private double afternoonUsage;
    private double usageCharges;

    private double saleTax;
    private double environmentalRebate;
    private double regulatoryCharges;

    public Bill(double morningUsage, double afternoonUsage, double eveningUsage, boolean renewableEnergy){
        this.morningUsage = morningUsage;
        this.afternoonUsage = afternoonUsage;
        this.eveningUsage = eveningUsage;
        this.usageCharges = (this.morningUsage * 0.132) + (this.afternoonUsage * 0.065) + (this.eveningUsage * 0.094);
        this.saleTax = this.usageCharges * 0.13;

        if(renewableEnergy == true){
            this.environmentalRebate = this.usageCharges * 0.08;
        }
        else{
            this.environmentalRebate = 0;
        }

        this.regulatoryCharges = this.saleTax - this.environmentalRebate;
    }

    public String getDetails(){
        return "Morning Usage: $" + this.morningUsage * 0.132 + "\n"
                + "Afternoon Usage: $" + this.afternoonUsage * 0.065 + "\n"
                + "Evening Usage: $" + this.eveningUsage * 0.095;
    }

    public String getTotalUsage(){
        return "Total usage charges: $" + this.usageCharges;
    }

    public String getTaxes() {
        return "Sales Tax: $" + this.saleTax + "\n"
                + "Environment Rebate: -$" + this.environmentalRebate + "\n"
                + "Total Regulatory charges: $" + this.regulatoryCharges;
    }

    public String getTotalBill(){
        return "Total Bill Amount: $" + (this.usageCharges + this.regulatoryCharges);
    }
}
