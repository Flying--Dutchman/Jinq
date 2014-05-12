package org.jinq.jpa.jpqlquery;

import java.util.List;


/**
 * Data structure used to represent JPQL queries and the conversions
 * needed to parse results into a form usable by Jinq.
 */
public abstract class JPQLQuery<T> implements JPQLFragment
{
   public static <U> JPQLQuery<U> findAllEntities(String entityName)
   {
      SelectFromWhere<U> query = new SelectFromWhere<>();
      From from = From.forEntity(entityName);
      query.cols = ColumnExpressions.singleColumn(
            new SimpleRowReader<>(), new FromAliasExpression(from));
      query.froms.add(from);
      return query;
   }
   
   public JPQLQuery()
   {
   }

   public abstract String getQueryString();
   public abstract List<GeneratedQueryParameter> getQueryParameters();

   public abstract RowReader<T> getRowReader();
   
   // TODO: If I code things carefully, maybe this method isn't needed.
//   public JPQLQuery<T> copy()
//   {
//      JPQLQuery<T> newQuery = new JPQLQuery<>();
//      newQuery.query = query;
//      return newQuery;
//   }
}