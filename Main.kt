//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val izolirovannyProvod = Izolprov(10, 100, 8.9, 1, 2.0)
    println("Вес изолированного провода: ${izolirovannyProvod.getWeight()}")

    //применение второго задания
    val meeting = DoughterClass("Демонстрация", 10.0, 100.0, 2)
    println("Название события: ${meeting.name}")
    println("Количество ораторов: ${meeting.n1}")
    println("Количество участников: ${meeting.n2}")
    println("Коэффициент Q: ${meeting.Q}")
    println("Число групп с одинаковыми мыслями: ${meeting.P}")
    println("Коэффициент Qp:  ${meeting.QP}")
}
// Вариант 20, Класс-родитель: Цилиндр: диаметр основания, высота
//Вычислить объем цилиндра
//Вычисли площадь поверхности цилиндра
 open class Tsilindr(val diameter:Int, val height:Int)
{
               fun getVolume():Double{
                   val radius=0
                   return Math.PI*Math.PI*radius*height
               }
               fun getSquare():Double{
                   return Math.PI*diameter*height
               }
}

//класс-потомок: Изолированный провод: диаметр, длина, удельный вес; толщина изоляции и её удельный вес
//Определить вес изолированного провода
class Izolprov(  diameter: Int,
                 height: Int,
                 val ud_ves_provodnika: Double,
                 val thickness_izol: Int,
                 val ud_ves_izol: Double)
    :Tsilindr(diameter, height){
    fun getWeight(): String {
        val volume_provodnika = getVolume()
        val weight_provodnika = volume_provodnika * ud_ves_provodnika
        val external_radius = (diameter / 2.0) + thickness_izol
        val volume_izol = Math.PI * external_radius * external_radius * height - volume_provodnika
        val weight_izol = volume_izol * ud_ves_izol

        return  String.format("%.2f",(weight_provodnika + weight_izol)).toString()
    }
    }


// Второе задание
//родительский класс: Митинг:
// - название события;
// n1 – число ораторов;
// n2 – число участников.
//Q = n1/n2
///Дочерний класс:P: число групп ораторов,
//которые высказывали
//одинаковые мысли
//Qp = Q + Р/n2
open class Meeting(val name:String, val n1:Double, val n2:Double){
    val Q=n1/n2
}
class DoughterClass(name:String, n1:Double, n2:Double,val P:Int):Meeting(name,n1,n2){
    val QP=Q+(P/n2)
}