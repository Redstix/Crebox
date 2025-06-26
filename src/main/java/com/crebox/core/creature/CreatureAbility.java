package com.crebox.core.creature;

public class CreatureAbility {
    // 使用final修饰符确保能力值在创建后不可修改
    public int photoSynAbility;
    public int predatoryAbility;
    public int mobilityAbility;
    public int coldResistance;
    public int heatResistance;
    public int selfDefenseAbility;
    public CreatureAbility() {
        this.photoSynAbility = 10;
        this.predatoryAbility = 10;
        this.mobilityAbility = 10;
        this.coldResistance = 10;
        this.heatResistance = 10;
        this.selfDefenseAbility = 10;
    }
    // 全参数构造器，包含范围检查(0-100)
    public CreatureAbility(int photoSynAbility, int predatoryAbility, int mobilityAbility,
                           int coldResistance, int heatResistance, int selfDefenseAbility) {
        validateAbilityRange("光合能力", photoSynAbility);
        validateAbilityRange("捕食能力", predatoryAbility);
        validateAbilityRange("移动能力", mobilityAbility);
        validateAbilityRange("抗冷能力", coldResistance);
        validateAbilityRange("抗热能力", heatResistance);
        validateAbilityRange("自卫能力", selfDefenseAbility);

        this.photoSynAbility = photoSynAbility;
        this.predatoryAbility = predatoryAbility;
        this.mobilityAbility = mobilityAbility;
        this.coldResistance = coldResistance;
        this.heatResistance = heatResistance;
        this.selfDefenseAbility = selfDefenseAbility;
    }

    // 范围验证辅助方法
    private void validateAbilityRange(String name, int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(name + "必须在0-100范围内: " + value);
        }
    }

    // 计算公式函数 y = x/10 + x^3/10000
    public double calculateTotalAbility() {
        double total = 0;
        total += calculateSingleAbility(photoSynAbility);
        total += calculateSingleAbility(predatoryAbility);
        total += calculateSingleAbility(mobilityAbility);
        total += calculateSingleAbility(coldResistance);
        total += calculateSingleAbility(heatResistance);
        total += calculateSingleAbility(selfDefenseAbility);
        return total;
    }

    // 单能力值计算辅助方法
    private double calculateSingleAbility(int value) {
        return value / 10.0 + Math.pow(value, 3) / 10000.0;
    }
}
