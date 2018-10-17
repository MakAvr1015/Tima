/**
 * 
 */
		var app = new Vue({
			el : '#app',
			data: {
			      navigator: [
				        { title: 'Закупки', icon: 'shopping_basket', method: 'saleList' },
				        { title: 'Продажи', icon: 'money', method: 'moneyList' },
				        { title: 'Склад', icon: 'storage' , method: 'moneyList'},
				        { title: 'Справочники', icon: 'question_answer' , method: 'moneyList'},
				        { title: 'Отчеты', icon: 'description' , method: 'moneyList'},
				        { title: 'Инструменты', icon: 'receipt' , method: 'moneyList'}
				      ],
				      menuitems: [
				    	  {caption: 'Создать'},
				    	  {caption: 'Печать'},
				    	  {caption: 'Обновить'}
				      ],
				      
				      headers: [
				          {
				            text: 'Dessert (100g serving)',
				            align: 'left',
				            sortable: false,
				            value: 'name'
				          },
				          { text: 'Calories', value: 'calories' },
				          { text: 'Fat (g)', value: 'fat' },
				          { text: 'Carbs (g)', value: 'carbs' },
				          { text: 'Protein (g)', value: 'protein' },
				          { text: 'Iron (%)', value: 'iron' }
				        ],
				        desserts: [
				          {
				            value: false,
				            name: 'Frozen Yogurt',
				            calories: 159,
				            fat: 6.0,
				            carbs: 24,
				            protein: 4.0,
				            iron: '1%'
				          },
				          {
				            value: false,
				            name: 'Ice cream sandwich',
				            calories: 237,
				            fat: 9.0,
				            carbs: 37,
				            protein: 4.3,
				            iron: '1%'
				          }],			      
				      right: null
				
			},
			methods:{
				saleList: function(){
					return
				}
			}	  
		})
