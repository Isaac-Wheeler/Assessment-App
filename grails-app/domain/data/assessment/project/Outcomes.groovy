package data.assessment.project

class Outcomes {


    //NOTE: DB creates ID for table
    char outcomeCategory;
    String outcomeCategoryDescription;

    static hasMany = [ indicators : Indicators ]




    static constraints = {
      /*indicators validator: { indicators, obj ->
          Set names = new HashSet()
          for (Indicators indicator in indicators) {
              if (!names.add(indicator.indicatorName)) {
                returnf false
              }

          }
          return true
      } */

      outcomeCategory blank:false, unique:true
      outcomeCategoryDescription blank:false

      }

}
