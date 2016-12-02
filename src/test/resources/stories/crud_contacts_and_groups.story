Narrative:
In order to impress better
As a candidate
I should use bdd in my tests

Scenario: Add user(positive)

Given the user is on the contact grid page
When the user click on "+" button
Then contact edit page is opened
When he enters information to corresponding fields $name, $lastName, $twitter, $skype, $imgUrl, $notes
And clicks "SAVE" button
Then popup message $message appeared
When he enters $name to the search field
Then the user with name $name $isPresent on the page

Examples:

|name|lastName|twitter|skype|imgUrl|notes|message|isPeresent
|Janifer|Ivanova|twitter.com/id11111|panas|http://3.bp.blogspot.com/-XJZO-IUsduQ/U3OfFg9NqpI/AAAAAAAAWys/1MRlS2Yosvk/s1600/ISABEL-SPEARMINT.jpg|Hi my little pony|Contact saved!|is|
|Archibalt|Pupkin|twitter.com/id22222|http://img14.deviantart.net/0fa3/i/2012/243/1/f/male_stock_by_vishstudio-d5d1yf6.jpg|Will get you beck soon||Contact saved!|is|

Scenario: Add user(negative)

Given user is on the contact grid page
When user click on "+" button
Then contact edit page is opened
When enter only $name to the corresponding text field
Then "SAVE" button is not clickable
When enter only $lastName to the corresponding text field
Then "SAVE" button is not clickable
When leave all fields empty
Then "SAVE" button is not clickable

Examples:

|name|
|name1|
|name2|

Scenario: Add group(positive)

Given the user is on the group grid page
When user click on "+" button
Then group edit popup page is open
When enter $groupName ti the text field
And click "SAVE" button
Then popup message $popupMessage appeared
When entering $groupName to the search field
Then the group with $groupName $isGroupPresent on the page

Examples:

|groupName|popupMessage|isGroupPresrnt|
|Group1|Group created!|is|
|Group2|Group created!|is|
|Group1|Group created!|is not|

Scenario: Add group(negative)

Given user is on the group grid page
When user click on "+" button
Then group edit popup page is open
When leave name field empty
Then "SAVE" button is not clickable
