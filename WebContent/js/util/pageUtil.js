/**
 * 生成分页数字按钮  起始也按0计算
 * pageCount 总页数
 * size 分页按钮显示数量
 * pageNum  当前页数
 * 返回 数组
 */
function BuildPage(pageCount,size,pageNum){
	//变量
	var start = 0;//开始页数
	var end = 0;//结束页数
	//防止传入数字字符串   先转换
	pageCount = Number(pageCount);
	size = Number(size);
	pageNum = Number(pageNum);
	//浮点数取整  
	var midPage = Math.ceil(size/2);
	//1.判断 总页数是否 小于 需要显示的按钮数
	if(pageCount <= size){
		//1.1 小于   结束页  就等于 最后一页
		end = pageCount;
	}else{//大于需要显示的数量
		//1.2 不小于   找出 结束页的位置
		//当前页小于 中间页
		if(pageNum <= midPage){
			end = size;
		}else{
			end = pageNum + midPage - 1;
			if(end > pageCount){// 如果结束页超出了 总页数  则结束页 就只能 最大为 总页数
				end = pageCount;
			}
		}
	}
	//查找起始页的位置
	if(end <= size){
		start = 1;
	}else{
		start = end - size +1;
	}
	
	  //创建数组实现数字分页
    var a = new Array();
    for (var i = start; i <= end; i++) {
        a. push(i);
    }
    return a;
}