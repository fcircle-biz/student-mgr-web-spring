## 生徒管理SpringMVC

ブラウザ上でソースが見にくいならダウンロードしてください。   
「<> Code」→「Download Zip」  

### ①宣言的トランザクション（SpringにDBトランザクション制御を任せる）  
　→ServiceとDAOをSpring管理対象とする。  
　[DAO]  
　1.DAOに@Componentアノテーションを付与  
　2.DataSourceをインジェクション  
　3.DB接続修正：Connection conn = DataSourceUtils.getConnection(dataSource);  
　[Service]  
　1.Serviceに@Service、@Transactionalを付与  
  2.DAOをインジェクション  
  3.明示的トランザクション（DB接続、切断、コミットなど）のコードは全削除  
　4.Serviceの例外はRuntimeExceptionに変更→SystemExceptionを作って対応  
　[Controller]  
    1.Serviceをインジェクション  
    
### ②登録完了時のブラウザ更新で再登録が行われる問題  
　→PRGパターン導入  
