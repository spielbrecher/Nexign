package myfamily;

/**
 * Сеть для распознавания семейных ситуаций
 * @author Andy Jagello
 */
public class Perceptron {
    
    private double[] enters;
    private double[][] synapses;
    private double[] outers;
    
    private double[][] patterns = {
        // Все дома
        {
            0,0,0,0,0,0,0,0,0,0,
            0,4,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0            
        },
        // Родители на работе, дети дома
        {
            0,0,0,0,0,0,0,0,0,0,
            0,2,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,1,0,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0                        
        },
        // Родители на работе, дети в школе
        {
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,2,0,0,
            0,0,1,0,1,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0     
        },
    };
    
    private double[][] answers = {
        {1,0,0}, // Все дома
        {0,1,0}, // Родители на работе, дети дома
        {0,0,1}  // Родители на работе, дети в школе
    };

    public Perceptron(){
        enters = new double[patterns[0].length];
        outers = new double[patterns.length];
        synapses = new double[enters.length][outers.length];
        study();
        for(int p=0; p<patterns.length; p++){
                for(int i=0; i<enters.length; i++)
                    enters[i] = patterns[p][i];
                
                propagate();
                System.out.println(""+outers[0]+" "+outers[1]+" "+outers[2]);
        }
        
    }
    
    // Расчет выхода сети
    public void propagate(){
        for(int j=0; j<outers.length; j++){
            outers[j]=0;
            for(int i=0; i<enters.length; i++){
                outers[j] += enters[i]*synapses[i][j];
            }
            if(outers[j]>0.5) outers[j]=1; else outers[j]=0;            
        }
    }
    
    public void setEnters(double[] enters){
        this.enters=enters;
    }
    
    public double[] getOuters(){
        return outers;
    }
    
    // Обучение сети
    public void study(){
        // Инициализация синапсов        
        for(int i=0; i<enters.length; i++)
            for(int j=0; j<outers.length; j++)
                synapses[i][j]=Math.random()*0.2+0.1;
        
        // Обучающий цикл
        double gError=0;
        int k=0;
        do{
            k++;
            gError=0;
            // Подаем шаблоны на вход, вычисляем выход, ошибку и корректируем синапсы
            for(int p=0; p<patterns.length; p++){
                for(int i=0; i<enters.length; i++)
                    enters[i] = patterns[p][i];
                
                propagate();
                
                double[] errors = new double[outers.length]; // Ошибки на нейронах
                for(int i=0; i<outers.length; i++)
                    errors[i] = answers[p][i] - outers[i]; // Разница между идеальным и реальным значением
                for(int e=0; e<errors.length; e++)
                    gError+=Math.abs(errors[e]); // Суммируем их по модулю в глобальную
                
                //Корректируем синапсы
                for(int i=0; i<enters.length; i++)
                    for(int j=0; j<outers.length; j++){
                        synapses[i][j] += 0.1*enters[i]*errors[j];
                    }
            }
        }while(gError!=0);
        System.out.println("Обучился за "+k+" итераций");
    }
    
}
