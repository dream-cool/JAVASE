
import org.junit.Test;
import util.DataAccess;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 10000个用户，1.生成10000个32位随机数
 * 2.一万个用户随机姓名
 * 3.一万个随机手机号
 * 4.一万个随机地址
 * 5.一万个创建日期，修改日期
 * 2018.05.06 00：00：00到2019.03.04 00：00：00
 */


public class Main {
    public static String getRandomTel() {
        StringBuilder sb = new StringBuilder("1");
        Random random = new Random();
        sb.append(random.nextInt(9) + 1);
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String getRandomName() {
        Random random = new Random();
        int len = random.nextInt(2) + 1;
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBk"); //转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        return ret;
    }

    public static String getChineseFamilyName() {

        String str = null;

        Random random = new Random();

        /* 598 百家姓 */

        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",

                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",

                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",

                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",

                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",

                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟",

                "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应",

                "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀",

                "羊", "于", "惠", "甄", "曲", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山",

                "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘", "景",

                "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠",

                "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却",

                "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习",

                "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",

                "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空",

                "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉",

                "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归", "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨",

                "哈", "谯", "篁", "年", "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭", "舜", "楼",

                "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦", "召", "仪", "风", "介", "巨",

                "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端", "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾",

                "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正",

                "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇",

                "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生",

                "梁丘", "左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门",

                "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙"};

        int index = random.nextInt(Surname.length - 1);

        str = Surname[index]; //获得一个随机的姓氏

        return str;

    }

    public static char getRandomChar() {

        Random random = new Random();

        /* 随机数字字符 */

        char[] Surname = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z'};
        int index = random.nextInt(Surname.length - 1);

        char ch = Surname[index]; //获得一个随机的字符

        return ch;

    }

    public static char getRandomLowChar() {

        Random random = new Random();

        /* 随机数字字符 */

        char[] Surname = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int index = random.nextInt(Surname.length - 1);

        char ch = Surname[index]; //获得一个随机的字符

        return ch;

    }

    public static char getRandomUpChar() {

        Random random = new Random();

        /* 随机数字字符 */

        char[] Surname = {'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z'};
        int index = random.nextInt(Surname.length - 1);

        char ch = Surname[index]; //获得一个随机的字符

        return ch;

    }

    public static Date getRandomDate(String start, String end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);
            if (startDate.getTime() - endDate.getTime() >= 0) {
                return null;
            }
            long rand = (long) (startDate.getTime() + (Math.random() * (endDate.getTime() - startDate.getTime())));
            return new Date(rand);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRandomAddress() {
        String[] pro = {"北京", "天津", "上海", "重庆", "河北", "山西", "辽宁", "吉林", "黑龙江", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "海南", "四川", "贵州", "云南", "陕西", "甘肃", "青海", "内蒙古", "广西", "西藏", "宁夏", "新疆维吾尔自治区", "香港", "澳门", "台湾"};
        String[][] city = {{"东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "房山区", "通州区",
                "顺义区", "昌平区", "大兴区", "怀柔区", "平谷区", "门头沟区", "密云县", "延庆县"}, {"和平区", "河东区", "河西区",
                "南开区", "河北区", "红桥区", "东丽区", "西青区", "北辰区", "津南区", "武清区", "宝坻区", "滨海新区", "静海县",
                "宁河县", "蓟县"}, {"黄浦区", "卢湾区", "徐汇区", "长宁区", "静安区", "普陀区", "闸北区", "虹口区", "杨浦区",
                "闵行区", "宝山区", "嘉定区", "浦东新区", "金山区", "松江区", "青浦区", "奉贤区", "崇明县"}, {"渝中区",
                "大渡口区", "江北区", "南岸区", "北碚区", "渝北区", "巴南区", "长寿区", "双桥区", "沙坪坝区", "万盛区",
                "万州区", "涪陵区", "黔江区", "永川区", "合川区", "江津区", "九龙坡区", "南川区", "綦江县", "潼南县",
                "荣昌县", "璧山县", "大足县", "铜梁县", "梁平县", "开县", "忠县", "城口县", "垫江县", "武隆县", "丰都县",
                "奉节县", "云阳县", "巫溪县", "巫山县", "石柱土家族自治县", "秀山土家族苗族自治县", "酉阳土家族苗族自治县",
                "彭水苗族土家族自治县"}, {"石家庄", "唐山", "秦皇岛", "邯郸", "邢台", "保定", "张家口", "承德", "沧州", "廊坊",
                "衡水"}, {"太原", "大同", "阳泉", "长治", "晋城", "朔州", "晋中", "运城", "忻州", "临汾", "吕梁"}, {"沈阳", "大连",
                "鞍山", "抚顺", "本溪", "丹东", "锦州", "营口", "阜新", "辽阳", "盘锦", "铁岭", "朝阳", "葫芦岛"}, {"长春", "吉林",
                "四平", "辽源", "通化", "白山", "松原", "白城", "延边朝鲜族自治州"}, {"哈尔滨", "齐齐哈尔", "鹤岗", "双鸭山",
                "鸡西", "大庆", "伊春", "牡丹江", "佳木斯", "七台河", "黑河", "绥化", "大兴安岭"}, {"南京", "苏州", "无锡", "常州",
                "镇江", "南通", "泰州", "扬州", "盐城", "连云港", "徐州", "淮安", "宿迁"}, {"杭州", "宁波", "温州", "嘉兴", "湖州",
                "绍兴", "金华", "衢州", "舟山", "台州", "丽水"}, {"合肥", "芜湖", "蚌埠", "淮南", "马鞍山", "淮北", "铜陵", "安庆",
                "黄山", "滁州", "阜阳", "宿州", "巢湖", "六安", "亳州", "池州", "宣城"}, {"福州", "厦门", "莆田", "三明", "泉州",
                "漳州", "南平", "龙岩", "宁德"}, {"南昌", "景德镇", "萍乡", "九江", "新余", "鹰潭", "赣州", "吉安", "宜春", "抚州",
                "上饶"}, {"济南", "青岛", "淄博", "枣庄", "东营", "烟台", "潍坊", "济宁", "泰安", "威海", "日照", "莱芜", "临沂",
                "德州", "聊城", "滨州", "菏泽"}, {"郑州", "开封", "洛阳", "平顶山", "安阳", "鹤壁", "新乡", "焦作", "濮阳", "许昌",
                "漯河", "三门峡", "南阳", "商丘", "信阳", "周口", "驻马店"}, {"武汉", "黄石", "十堰", "荆州", "宜昌", "襄樊", "鄂州",
                "荆门", "孝感", "黄冈", "咸宁", "随州", "恩施"}, {"长沙", "株洲", "湘潭", "衡阳", "邵阳", "岳阳", "常德", "张家界",
                "益阳", "郴州", "永州", "怀化", "娄底", "湘西"}, {"广州", "深圳", "珠海", "汕头", "韶关", "佛山", "江门", "湛江",
                "茂名", "肇庆", "惠州", "梅州", "汕尾", "河源", "阳江", "清远", "东莞", "中山", "潮州", "揭阳", "云浮"}, {"海口",
                "三亚"}, {"成都", "自贡", "攀枝花", "泸州", "德阳", "绵阳", "广元", "遂宁", "内江", "乐山", "南充", "眉山", "宜宾",
                "广安", "达州", "雅安", "巴中", "资阳", "阿坝", "甘孜", "凉山"}, {"贵阳", "六盘水", "遵义", "安顺", "铜仁", "毕节",
                "黔西南", "黔东南", "黔南"}, {"昆明", "曲靖", "玉溪", "保山", "昭通", "丽江", "普洱", "临沧", "德宏", "怒江", "迪庆",
                "大理", "楚雄", "红河", "文山", "西双版纳"}, {"西安", "铜川", "宝鸡", "咸阳", "渭南", "延安", "汉中", "榆林", "安康",
                "商洛"}, {"兰州", "嘉峪关", "金昌", "白银", "天水", "武威", "酒泉", "张掖", "庆阳", "平凉", "定西", "陇南", "临夏",
                "甘南"}, {"西宁", "海东", "海北", "海南", "黄南", "果洛", "玉树", "海西"}, {"呼和浩特", "包头", "乌海", "赤峰",
                "通辽", "鄂尔多斯", "呼伦贝尔", "巴彦淖尔", "乌兰察布", "锡林郭勒盟", "兴安盟", "阿拉善盟"}, {"南宁", "柳州",
                "桂林", "梧州", "北海", "防城港", "钦州", "贵港", "玉林", "百色", "贺州", "河池", "来宾", "崇左"}, {"拉萨", "那曲",
                "昌都", "林芝", "山南", "日喀则", "阿里"}, {"银川", "石嘴山", "吴忠", "固原", "中卫"}, {"乌鲁木齐", "克拉玛依",
                "吐鲁番", "哈密", "和田", "阿克苏", "喀什", "克孜勒苏", "巴音郭楞", "昌吉", "博尔塔拉", "伊犁", "塔城", "阿勒泰"},
                {"香港岛", "九龙东", "九龙西", "新界东", "新界西"}, {"澳门半岛", "离岛"}, {"台北", "高雄", "基隆", "新竹", "台中", "嘉义", "台南市"}};
        Random random = new Random();
        int proNumber = random.nextInt(34);
        String address = pro[proNumber] + city[proNumber][random.nextInt(city[proNumber].length)];
        return address;
    }

    public static String getRandomEmail() {
        String email = "";
        String[] emailFormat = {"@qq.com", "@gmail.com", "com@163.net", "@mail.com", "@163.com", "@sohu.com",
                "@yahoo.com", "@126.com", "@188.com", "@hotmail.com"};
        Random random = new Random();
        boolean falg = random.nextInt(2) == 1;
        int numberLength;
        if (falg){
            numberLength = 7 - 2 ;
        } else {
            numberLength = 9 + random.nextInt(3);
        }
        int charLength = 3 + random.nextInt(2);
        for (int i = 0; i < numberLength; i++) {
            if (i==0){
                email += random.nextInt(9)+1;
            } else {
                email += random.nextInt(10);
            }
        }
        if (falg) {
            for (int i = 0; i < charLength; i++) {
                email += getRandomLowChar();
            }
        }
        email += emailFormat[random.nextInt(10)];
        return email;
    }



}



class test {
    public static void main(String[] args) {
        String data;
        String address = null;
        Date createTime = null;
        Date updateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 100; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 32; j++) {
                sb.append(Main.getRandomChar());
            }
            address = Main.getRandomAddress();
            createTime = Main.getRandomDate("2018-5-6", "2019-3-4");
            updateTime = Main.getRandomDate(sdf.format(createTime), sdf.format(new Date()));
            String create = sdf.format(createTime);
            String update = sdf.format(updateTime);
//            data = "编号:" + sb.toString() + " 姓名:" + Main.getChineseFamilyName() + Main.getRandomName() + " 电话:"
//                    + Main.getRandomTel() + " 地址:" + address + " 创建日期:" + create + " 修改日期:" + update;
            System.out.printf("%32s\t%-10s\t%11s\t%-26s\t%10s\t%10s\n", sb.toString(), Main.getChineseFamilyName() + Main.getRandomName(),
                    Main.getRandomTel(), address, create, update);
        }
    }
}

class category {
    public static void main(String[] args) {
        File file = new File("C:/Users/Mrchen/Desktop/category1.txt");
        OutputStream os = null;
        String data;
        String[] name = {"小吃", "火锅", "主食", "甜点", "酒水", "湘菜"};
        int type;
        Random random = new Random();
        Date createTime = null;
        Date updateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (int i = 10000; i < 1000000; i++) {
                createTime = Main.getRandomDate("2018-5-6", "2019-3-4");
                updateTime = Main.getRandomDate(sdf.format(createTime), sdf.format(new Date()));
                String create = sdf.format(createTime);
                String update = sdf.format(updateTime);
                type = random.nextInt(6);
                data = "insert into product_category (category_name, category_type, create_time, update_time) " +
                        "values(\"" + name[type] + "\"," + type + ",\'" + create + "\',\'" + update + "\')";
                os = new FileOutputStream(file, true);
                os.write(data.getBytes());
                os.write("\n".getBytes());
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class categoryNotIO {
    public static void main1(String[] args) {
        String[] name = {"小吃", "火锅", "主食", "甜点", "酒水", "湘菜"};
        String data = null;
        int count = 0;
        int type;
        Random random = new Random();
        Date createTime = null;
        Date updateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DataAccess.getConnection();
        for (int i = 10000; i < 1000000; i++) {
            StringBuilder sb = new StringBuilder();
            createTime = Main.getRandomDate("2018-5-6", "2019-3-4");
            updateTime = Main.getRandomDate(sdf.format(createTime), sdf.format(new Date()));
            String create = sdf.format(createTime);
            String update = sdf.format(updateTime);
            type = random.nextInt(6);
            data = "insert into product_category (category_name, category_type, create_time, update_time) " +
                    "values(\"" + name[type] + "\"," + type + ",\'" + create + "\',\'" + update + "\')";
            count++;

            try {
                pst = con.prepareStatement(data);
                pst.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if ((count & 999) == 0) {
                System.out.println(count + "-------" + System.currentTimeMillis());
            }
        }
    }

    @Test
    /**
     * 生成用户数据
     */
    public static void main(String[] args) {
        String data = null;
        int count = 0;
        Random random = new Random();
        Date createTime = null;
        Date updateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DataAccess.getConnection();
        for (int i = 1; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            String userName = Main.getChineseFamilyName() + Main.getRandomName();
            String passWord = Main.getRandomTel();
            String tel = Main.getRandomTel();
            String address = Main.getRandomAddress();
            String money = "" + new Random().nextInt(1000);
            String sex = "" + (new Random().nextInt(2));
            String state = "" + (new Random().nextInt(2));
            String isVIP = "" + (new Random().nextInt(2));
            String email = Main.getRandomEmail();
            createTime = Main.getRandomDate("2013-5-6", "2019-3-4");
            updateTime = Main.getRandomDate(sdf.format(createTime), sdf.format(new Date()));
            String create = sdf.format(createTime);
            String update = sdf.format(updateTime);
            data = "insert into ording.user (user_name,pass_word,tel,email,address,money,sex,state ,isVIP,reg_time, last_login_time )" +
                    " values('" + userName + "'," + passWord + "," + tel + ",'" + email + "','" + address + "'," + money + "," + sex + "," + state + "," + isVIP + ",'" + create + "','" + update + "')";
            System.out.println(data);
            count++;
            try {
                pst = con.prepareStatement(data);
                pst.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if ((count & 999) == 0) {
                System.out.println(count + "-------" + System.currentTimeMillis());
            }
        }
    }
}

/**
 * create table `product_info` (
 * `product_id` varchar(32) not null,
 * `product_name` varchar(64) not null comment '商品名称',
 * `product_price` decimal(8,2) not null comment '单价',
 * `product_stock` int not null comment '库存',
 * `product_description` varchar(64) comment '描述',
 * `product_icon` varchar(512) comment '小图',
 * `product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
 * `category_type` int not null comment '类目编号',
 * `create_time` timestamp not null default current_timestamp comment '创建时间',
 * `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
 * primary key (`product_id`)
 * );
 */
class product {
    public static void main(String[] args) {
        File file = new File("C:/Users/Mrchen/Desktop/product.txt");
        OutputStream os = null;
        String data;
        String productName = null;
        float price = 0;
        int stock = 0;
        String decription = null;
        int productStatus;
        int productType;
        Random random = new Random();
        Date createTime = null;
        Date updateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (int i = 10000; i < 1000000; i++) {
                StringBuilder sb = new StringBuilder();
                createTime = Main.getRandomDate("2018-5-6", "2019-3-4");
                updateTime = Main.getRandomDate(sdf.format(createTime), sdf.format(new Date()));
                String create = sdf.format(createTime);
                String update = sdf.format(updateTime);
                productName = Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName();
                decription = Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName();
                price = (float) random.nextInt(100);
                stock = random.nextInt(1000);
                productStatus = random.nextInt(2);
                productType = random.nextInt(6);
                data = "insert into product_info (product_id,product_name, product_price, product_stock, product_description" +
                        ", product_status, category_type, create_time, update_time) " +
                        "values(\"" + i + "\",\"" + productName + "\"," + price + "," + stock + ",\"" + decription + "\",\"" + productStatus + "\",\""
                        + productType + "\", \'" + create + "\',\'" + update + "\')";
                os = new FileOutputStream(file, true);
                os.write(data.getBytes());
                os.write("\n".getBytes());
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class productNotIO {
    public static void main(String[] args) {
        String data;
        String productName = null;
        float price = 0;
        int stock = 0;
        String decription = null;
        int productStatus;
        int productType;
        Random random = new Random();
        Date createTime = null;
        Date updateTime = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DataAccess.getConnection();
        int count = 0;
        for (int i = 10000; i < 1000000; i++) {
            StringBuilder sb = new StringBuilder();
            createTime = Main.getRandomDate("2018-5-6", "2019-3-4");
            updateTime = Main.getRandomDate(sdf.format(createTime), sdf.format(new Date()));
            String create = sdf.format(createTime);
            String update = sdf.format(updateTime);
            productName = Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName();
            decription = Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName() + Main.getRandomName();
            price = (float) random.nextInt(100);
            stock = random.nextInt(1000);
            productStatus = random.nextInt(2);
            productType = random.nextInt(6);
            data = "insert into product_info (product_id,product_name, product_price, product_stock, product_description" +
                    ", product_status, category_type, create_time, update_time) " +
                    "values(\"" + i + "\",\"" + productName + "\"," + price + "," + stock + ",\"" + decription + "\",\"" + productStatus + "\",\""
                    + productType + "\", \'" + create + "\',\'" + update + "\')";
            try {
                pst = con.prepareStatement(data);
                pst.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if ((count & 999) == 0) {
                System.out.println(count + "-------" + System.currentTimeMillis());
            }
        }
    }
}

class test2 {
    public static void main(String[] args) {
        timesTest();
    }

    public static void timesTest() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
//            StringBuilder sb = new StringBuilder();
            if ((i & 999) == 0) {
                System.out.println(i + "---" + System.currentTimeMillis());
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void sqlTest() {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Connection con = DataAccess.getConnection();
        String sql = "select * from product_category where category_id = ?";
        try {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000; i++) {
                pst = con.prepareStatement(sql);
                pst.setInt(1, i);
                pst.executeQuery();
                if ((i & 999) == 0) {
                    System.out.println(i + "---" + System.currentTimeMillis());
                }
            }
            System.out.println(System.currentTimeMillis() - start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class test3 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Main.getRandomEmail());
        }
    }
}

