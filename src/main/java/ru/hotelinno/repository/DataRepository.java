//package ru.hotelinno.repository;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
////import ru.hotelinno.domain.Book;
//
//import java.util.List;
//
//@Repository
//@Transactional
//public class DataRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
////    public void addRecord(Book book){ //addB ook
////        this.sessionFactory
////                .getCurrentSession()
////                .save(book);
////    }
//
////    public List<Book> listAll(){
////        return this.sessionFactory
////                .getCurrentSession()
////                .createQuery("from Book")
////                .list();
////    }
//
////    //удаление не работает почему-то - вроде бы починилось
////    public void remove(Integer id){ //removeB ook
////        Book contact = (Book) this.sessionFactory
////                .getCurrentSession()
////                .load(Book.class, id);
////        if (null != contact) {
////            this.sessionFactory
////                    .getCurrentSession()
////                    .delete(contact);
////        }
////    }
//}