<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/common/taglib.jsp" %>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


   <div class="container">
    <canvas id="myChart"></canvas>
</div>

<script>
    let myChart = document.getElementById('myChart').getContext('2d');

    Chart.defaults.global.defaultFontFamily = 'Lato';
    Chart.defaults.global.defaultFontSize = 18;
    Chart.defaults.global.defaultFontColor = '#777';

    let massPopChart = new Chart(myChart, {
      type:'bar', 
      data:{
        labels:['January', 'February', 'March', 'April', 'May', 'June','July','August','September','October','November','December'],
        datasets:[{
          label:'Income',
          data:[
 				${monthInmome.january},
 				${monthInmome.february},
 				${monthInmome.march},
 				${monthInmome.april},
 				${monthInmome.may},
 				${monthInmome.june},
 				${monthInmome.july},
 				${monthInmome.august},
 				${monthInmome.september},
 				${monthInmome.october},
 				${monthInmome.november},
 				${monthInmome.december},
 				
          ],

          backgroundColor:[
			
          ],
          borderWidth:1,
          borderColor:'#777',
          hoverBorderWidth:3,
          hoverBorderColor:'#000'
        }]
      },
      options:{
        title:{
          display:true,
          text:'InComeThisYear',
          fontSize:25
        },
        legend:{
          display:true,
          position:'right',
          labels:{
            fontColor:'#000'
          }
        },
        layout:{
          padding:{
            left:50,
            right:0,
            bottom:0,
            top:0
          }
        },
        tooltips:{
          enabled:true
        }
      }
    });
  </script>
  
  
  <div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">

    </nav>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <h2>TABLE</h2>
      <div class="table-responsive">
        <table class="table table-striped table-sm">
          <thead>
            <tr>
           	 <th scope="col">StoreID</th>
              <th scope="col">OrderID</th>
              <th scope="col">CustomerID</th>
              <th scope="col">Income</th>
              <th scope="col">CompleteDate</th>
            </tr>
          </thead>
          <tbody>
          <c:forEach items="${incomes}" var="income">
            <tr>
            	<td>${income.storeId}</td>
              	<td>${income.orderId}</td>
              	<td>${income.orderUserId}</td>
           		<td>${income.income}</td>
             	<td>${income.dateComplete}</td>
            </tr>
          
          </c:forEach>
          </tbody>
        </table>
      </div>
    </main>
  </div>
</div>

