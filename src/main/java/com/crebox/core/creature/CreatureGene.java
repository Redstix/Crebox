package com.crebox.core.creature;

import java.util.Random;

public class CreatureGene {
    // 使用final修饰符确保能力值在创建后不可修改
    public double photoSynAbility;
    public double huntAbility;
    public double moveAbility;
    public double coldProofAbility;
    public double heatProofAbility;
    public double selfDefenseAbility;
    public CreatureGene(double photoSynAbility, double huntAbility,
                        double moveAbility, double coldProofAbility,
                        double heatProofAbility, double selfDefenseAbility) {
        this.photoSynAbility = photoSynAbility;
        this.huntAbility = huntAbility;
        this.moveAbility = moveAbility;
        this.coldProofAbility = coldProofAbility;
        this.heatProofAbility = heatProofAbility;
        this.selfDefenseAbility = selfDefenseAbility;
    }
    public CreatureGene() {
        this.photoSynAbility = 10;
        this.huntAbility = 10;
        this.moveAbility = 10;
        this.coldProofAbility = 10;
        this.heatProofAbility = 10;
        this.selfDefenseAbility = 10;
    }
    // 全参数构造器，包含范围检查(0-100)
    public CreatureGene(int photoSynAbility, int huntAbility, int moveAbility,
                        int coldProofAbility, int heatProofAbility, int selfDefenseAbility) {
        validateAbilityRange("光合能力", photoSynAbility);
        validateAbilityRange("捕食能力", huntAbility);
        validateAbilityRange("移动能力", moveAbility);
        validateAbilityRange("抗冷能力", coldProofAbility);
        validateAbilityRange("抗热能力", heatProofAbility);
        validateAbilityRange("自卫能力", selfDefenseAbility);

        this.photoSynAbility = photoSynAbility;
        this.huntAbility = huntAbility;
        this.moveAbility = moveAbility;
        this.coldProofAbility = coldProofAbility;
        this.heatProofAbility = heatProofAbility;
        this.selfDefenseAbility = selfDefenseAbility;
    }

    // 范围验证辅助方法
    private void validateAbilityRange(String name, int value) {
        if (value < 0 || value > 10000) {
            throw new IllegalArgumentException(name + "必须在0-10000范围内: " + value);
        }
    }

    // 计算公式函数 y = x/10 + x^3/10000
    public double calculateTotalEnergyNeedPerSecond() {
        double total = 0;
        total += calculateSingleAbility(photoSynAbility);
        total += calculateSingleAbility(huntAbility);
        total += calculateSingleAbility(moveAbility);
        total += calculateSingleAbility(coldProofAbility);
        total += calculateSingleAbility(heatProofAbility);
        total += calculateSingleAbility(selfDefenseAbility);
        return total;
    }
    public double calculateTotalEnergyNeedToClone() {
        return calculateTotalEnergyNeedPerSecond()*60;
    }

    // 单能力值计算辅助方法
    private double calculateSingleAbility(double value) {
        return value / 10.0 + Math.pow(value, 3) / 10000.0 +20;
    }
    public CreatureGene getRandomChangedGene() {
        Random rand = new Random();
        return new CreatureGene(
                photoSynAbility + (rand.nextDouble() * 0.2 - 0.1),  // [-0.1, 0.1]
                huntAbility + (rand.nextDouble() * 0.2 - 0.1),
                moveAbility + (rand.nextDouble() * 0.2 - 0.1),
                coldProofAbility + (rand.nextDouble() * 0.2 - 0.1),
                heatProofAbility + (rand.nextDouble() * 0.2 - 0.1),
                selfDefenseAbility + (rand.nextDouble() * 0.2 - 0.1)
        );
    }

}
