package threadClass.waitNotify;

/**
 * Created by Ежище on 23.11.2016.
 * Задача: Рабочий спит неопределенное время (не более 3000мс), затем производит болванку за 50мс и засыпает снова.
 * Когда он произвел 3 болванки, просыпается Грузчик и относит их на склад, но в это время Рабочий не прекращает
 * работать (или спать). Грузчик снова идет спать, перед этим решив, сколько болванок он отнесет в следующий раз
 * (больше 2, но меньше 6). У него чуйка, он просыпается, когда болванок ровно столько, сколько он задумал. Иногда
 * (примерно в трети случаев, но без закономерности) рабочий хитрит и подкладывает пустую бутылку вместо болванки.
 * Грузчику все равно, что он несет, он неграмотный. А вот Кладовщик должен отделить зерна от плевел, выкинуть бутылки
 * и отправить 4 машины по 5 болванок в каждой, полупустые машины отправлять нельзя. После отправки машин он должен
 * записать, сколько всего времени было потрачено на производство и сколько болванок осталось на складе,
 * и отправить рабочего с грузчиком спать домой навсегда (производство закончено).
 * Можно в консоли или попробовать в окне.
 * PS "не прекращает работать" - это похоже на использование volatile или java.util.concurrent, или просто synchronized.
 */
public class MyWaitNotifyManufacturing {
    private int barsToSendToStorage = 3;
//    LinkedList<>

}
