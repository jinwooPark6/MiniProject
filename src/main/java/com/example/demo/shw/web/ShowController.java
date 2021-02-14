package com.example.demo.shw.web;

import static com.example.demo.cmm.utl.Util.integer;
import static com.example.demo.cmm.utl.Util.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.shw.service.Show;
import com.example.demo.shw.service.ShowMapper;
import com.example.demo.shw.service.ShowService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired ShowService showService;
    @Autowired Pagination page;
    @Autowired ShowMapper showMapper;

    @PostMapping("")
    public Messenger add(@RequestBody Show show) {
    	logger.info("======== 전시회 등록 ========"+show.toString());
    	return showMapper.insert(show)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    
    @GetMapping("/list")
    public List<Show> list() {
    	logger.info("======== 전시회 목록 ========");
        return showMapper.selectAll();
    }
    
    /*
    @GetMapping("/list/{pageSize}/{pageNum}")
    public Map<?,?> list(@PathVariable String pageSize, @PathVariable String pageNum) {
    	logger.info("=========== 목록 진입 ===========");
        var map = new HashMap<String, Object>();
    	var page = new Pagination(
				integer.apply(pageSize),
				integer.apply(pageNum),
				showMapper.count())
				;
    	map.put("list", showService.list(page));
    	map.put("page", page);
        return map;
    }
    
    @GetMapping("/page/{pageSize}/{pageNum}/selectAll")
    public List<?> selectAll(@PathVariable String pageSize, @PathVariable String pageNum){
    	logger.info("Shows List Execute ...");
    	var map = new HashMap<String, String>();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.SHOWS);	
        return showMapper.selectAll(new Pagination(
				Table.SHOWS.toString(), 
				integer.apply(pageSize),
				integer.apply(pageNum),
				commonMapper.totalCount(map)));
    }
    */
    @GetMapping("/{showNum}")
    public Show detail(@PathVariable int showNum) {
    	logger.info("======== 전시회 상세 ========");
        return showMapper.selectById(showNum);
    }
    
    @PutMapping("")
    public Messenger update(@RequestBody Show show){
    	logger.info("======== 목록 수정 ========"+show.toString());
    	return showMapper.update(show)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    
    @DeleteMapping("")
    public Messenger delete(@RequestBody Show show){
    	logger.info("======== 목록 삭제 ========"+show.getTitle());
        return showMapper.delete(show)==1?Messenger.SUCCESS:Messenger.FAILURE;
    }
    
    @GetMapping("/count")
    public String count() {
    	logger.info(String.format("Count Shows ..."));
    	var map = new HashMap<String,String>();
    	return string.apply(showMapper.count());
    }
   
}
