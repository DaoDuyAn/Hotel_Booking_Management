USE [booking_hotel_db]
GO
/****** Object:  Table [dbo].[account]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[pass] [nvarchar](50) NULL,
	[role_id] [int] NULL,
	[user_id] [int] NULL,
 CONSTRAINT [PK_account] PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[images]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[images](
	[image_id] [int] IDENTITY(1,1) NOT NULL,
	[image_link] [nvarchar](max) NULL,
	[room_type_id] [int] NULL,
 CONSTRAINT [PK_images] PRIMARY KEY CLUSTERED 
(
	[image_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[occupied_room]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[occupied_room](
	[occupied_room_id] [int] IDENTITY(1,1) NOT NULL,
	[check_in] [date] NULL,
	[check_out] [date] NULL,
	[room_id] [int] NULL,
	[reservation_id] [int] NULL,
 CONSTRAINT [PK_occupied_room] PRIMARY KEY CLUSTERED 
(
	[occupied_room_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[reservation]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reservation](
	[reservation_id] [int] IDENTITY(1,1) NOT NULL,
	[payment_status] [nvarchar](50) NULL,
	[booking_date] [date] NULL,
	[user_id] [int] NULL,
 CONSTRAINT [PK_reservation] PRIMARY KEY CLUSTERED 
(
	[reservation_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[reserved_room]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reserved_room](
	[reserved_room_id] [int] IDENTITY(1,1) NOT NULL,
	[reservation_id] [int] NOT NULL,
	[room_type_id] [int] NOT NULL,
	[num_of_rooms] [int] NULL,
	[guest_count] [int] NULL,
	[price] [bigint] NULL,
	[check_in] [date] NULL,
	[check_out] [date] NULL,
	[payment_status] [int] NULL,
	[status] [nvarchar](50) NULL,
 CONSTRAINT [PK_reserved_room_1] PRIMARY KEY CLUSTERED 
(
	[reserved_room_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[role]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[role_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[description] [nvarchar](50) NULL,
 CONSTRAINT [PK_role] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[room]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room](
	[room_id] [int] IDENTITY(1,1) NOT NULL,
	[room_type_id] [int] NULL,
 CONSTRAINT [PK_room] PRIMARY KEY CLUSTERED 
(
	[room_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[room_type]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[room_type](
	[room_type_id] [int] IDENTITY(1,1) NOT NULL,
	[room_type_name] [nvarchar](50) NULL,
	[description] [nvarchar](max) NULL,
	[size] [int] NULL,
	[capacity] [int] NULL,
	[price] [bigint] NULL,
 CONSTRAINT [PK_room_type] PRIMARY KEY CLUSTERED 
(
	[room_type_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 5/13/2024 4:17:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[dob] [date] NULL,
	[phone_number] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_user] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[account] ON 

INSERT [dbo].[account] ([account_id], [username], [pass], [role_id], [user_id]) VALUES (13, N'duyan', N'202cb962ac59075b964b07152d234b70', 1, 1)
INSERT [dbo].[account] ([account_id], [username], [pass], [role_id], [user_id]) VALUES (14, N'binh', N'289dff07669d7a23de0ef88d2f7129e7', 1, 3)
INSERT [dbo].[account] ([account_id], [username], [pass], [role_id], [user_id]) VALUES (17, N'mohas', N'd81f9c1be2e08964bf9f24b15f0e4900', 1, 6)
INSERT [dbo].[account] ([account_id], [username], [pass], [role_id], [user_id]) VALUES (18, N'andao', N'202cb962ac59075b964b07152d234b70', 2, 7)
INSERT [dbo].[account] ([account_id], [username], [pass], [role_id], [user_id]) VALUES (19, N'tavo', N'289dff07669d7a23de0ef88d2f7129e7', 2, 8)
SET IDENTITY_INSERT [dbo].[account] OFF
SET IDENTITY_INSERT [dbo].[images] ON 

INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (1, N'img/Apartments/apart_1.jpg', 10)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (2, N'img/Apartments/apart_2.jpg', 10)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (3, N'img/Apartments/apart_3.jpg', 10)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (4, N'img/Apartments/apart_4.jpg', 10)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (5, N'img/Connecting/con_1.jpg', 11)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (6, N'img/Connecting/con_2.jpg', 11)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (7, N'img/Connecting/con_3.jpg', 11)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (8, N'img/Connecting/con_4.jpg', 11)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (9, N'img/Double/double_1.jpg', 2)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (10, N'img/Double/double_2.jpg', 2)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (11, N'img/Double/double_3.jpg', 2)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (12, N'img/Double/double_4.jpg', 2)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (13, N'img/King/king_1.jpg', 6)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (14, N'img/King/king_2.jpg', 6)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (15, N'img/King/king_3.jpg', 6)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (16, N'img/King/king_4.jpg', 6)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (17, N'img/President/pre_1.jpg', 9)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (18, N'img/President/pre_2.jpg', 9)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (19, N'img/President/pre_3.jpg', 9)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (20, N'img/President/pre_4.jpg', 9)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (21, N'img/Quad/quad_1.jpg', 4)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (22, N'img/Quad/quad_2.jpg', 4)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (23, N'img/Quad/quad_3.jpg', 4)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (24, N'img/Quad/quad_4.jpg', 4)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (25, N'img/Queen/queen_1.jpg', 5)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (26, N'img/Queen/queen_2.jpg', 5)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (27, N'img/Queen/queen_3.jpg', 5)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (28, N'img/Queen/queen_4.jpg', 5)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (29, N'img/Single/single_1.jpg', 1)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (30, N'img/Single/single_2.jpg', 1)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (31, N'img/Single/single_3.jpg', 1)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (32, N'img/Single/single_4.jpg', 1)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (34, N'img/Triple/triple_1.jpg', 3)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (35, N'img/Triple/triple_2.jpg', 3)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (36, N'img/Triple/triple_3.jpg', 3)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (37, N'img/Triple/triple_4.jpg', 3)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (38, N'img/Twin/twin_1.jpg', 7)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (39, N'img/Twin/twin_2.jpg', 7)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (40, N'img/Twin/twin_3.jpg', 7)
INSERT [dbo].[images] ([image_id], [image_link], [room_type_id]) VALUES (41, N'img/Twin/twin_4.jpg', 7)
SET IDENTITY_INSERT [dbo].[images] OFF
SET IDENTITY_INSERT [dbo].[occupied_room] ON 

INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (10, CAST(N'2023-12-18' AS Date), CAST(N'2023-12-18' AS Date), 3, 6)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (14, CAST(N'2023-12-20' AS Date), CAST(N'2023-12-20' AS Date), 1, 7)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (15, CAST(N'2023-12-17' AS Date), CAST(N'2023-12-17' AS Date), 13, 3)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (16, CAST(N'2023-12-17' AS Date), CAST(N'2023-12-17' AS Date), 14, 3)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (17, CAST(N'2023-12-19' AS Date), CAST(N'2023-12-19' AS Date), 9, 4)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (18, CAST(N'2023-12-26' AS Date), CAST(N'2023-12-26' AS Date), 1, 8)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (19, CAST(N'2023-12-26' AS Date), CAST(N'2023-12-26' AS Date), 3, 8)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (20, CAST(N'2023-12-17' AS Date), CAST(N'2023-12-17' AS Date), 11, 3)
INSERT [dbo].[occupied_room] ([occupied_room_id], [check_in], [check_out], [room_id], [reservation_id]) VALUES (21, CAST(N'2023-12-17' AS Date), CAST(N'2023-12-17' AS Date), 12, 3)
SET IDENTITY_INSERT [dbo].[occupied_room] OFF
SET IDENTITY_INSERT [dbo].[reservation] ON 

INSERT [dbo].[reservation] ([reservation_id], [payment_status], [booking_date], [user_id]) VALUES (3, N'Unpaid', CAST(N'2023-12-17' AS Date), 1)
INSERT [dbo].[reservation] ([reservation_id], [payment_status], [booking_date], [user_id]) VALUES (4, N'Unpaid', CAST(N'2023-12-19' AS Date), 1)
INSERT [dbo].[reservation] ([reservation_id], [payment_status], [booking_date], [user_id]) VALUES (6, N'Paid', CAST(N'2023-12-19' AS Date), 1)
INSERT [dbo].[reservation] ([reservation_id], [payment_status], [booking_date], [user_id]) VALUES (7, N'Paid', CAST(N'2023-12-20' AS Date), 1)
INSERT [dbo].[reservation] ([reservation_id], [payment_status], [booking_date], [user_id]) VALUES (8, N'Unpaid', CAST(N'2023-12-26' AS Date), 1)
SET IDENTITY_INSERT [dbo].[reservation] OFF
SET IDENTITY_INSERT [dbo].[reserved_room] ON 

INSERT [dbo].[reserved_room] ([reserved_room_id], [reservation_id], [room_type_id], [num_of_rooms], [guest_count], [price], [check_in], [check_out], [payment_status], [status]) VALUES (7, 3, 6, 2, 1, 130, CAST(N'2023-12-17' AS Date), CAST(N'2023-12-17' AS Date), 10, N'Pending approval')
INSERT [dbo].[reserved_room] ([reserved_room_id], [reservation_id], [room_type_id], [num_of_rooms], [guest_count], [price], [check_in], [check_out], [payment_status], [status]) VALUES (8, 3, 7, 2, 1, 145, CAST(N'2023-12-17' AS Date), CAST(N'2023-12-17' AS Date), 100, N'Checked out')
INSERT [dbo].[reserved_room] ([reserved_room_id], [reservation_id], [room_type_id], [num_of_rooms], [guest_count], [price], [check_in], [check_out], [payment_status], [status]) VALUES (9, 4, 5, 1, 1, 120, CAST(N'2023-12-19' AS Date), CAST(N'2023-12-19' AS Date), 100, N'Approval')
INSERT [dbo].[reserved_room] ([reserved_room_id], [reservation_id], [room_type_id], [num_of_rooms], [guest_count], [price], [check_in], [check_out], [payment_status], [status]) VALUES (11, 6, 2, 1, 1, 100, CAST(N'2023-12-18' AS Date), CAST(N'2023-12-18' AS Date), 10, N'Cancel')
INSERT [dbo].[reserved_room] ([reserved_room_id], [reservation_id], [room_type_id], [num_of_rooms], [guest_count], [price], [check_in], [check_out], [payment_status], [status]) VALUES (12, 7, 1, 1, 1, 50, CAST(N'2023-12-20' AS Date), CAST(N'2023-12-20' AS Date), 10, N'Cancel')
INSERT [dbo].[reserved_room] ([reserved_room_id], [reservation_id], [room_type_id], [num_of_rooms], [guest_count], [price], [check_in], [check_out], [payment_status], [status]) VALUES (13, 8, 1, 1, 1, 50, CAST(N'2023-12-26' AS Date), CAST(N'2023-12-26' AS Date), 10, N'Pending approval')
INSERT [dbo].[reserved_room] ([reserved_room_id], [reservation_id], [room_type_id], [num_of_rooms], [guest_count], [price], [check_in], [check_out], [payment_status], [status]) VALUES (14, 8, 2, 1, 2, 100, CAST(N'2023-12-26' AS Date), CAST(N'2023-12-26' AS Date), 10, N'Pending approval')
SET IDENTITY_INSERT [dbo].[reserved_room] OFF
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([role_id], [name], [description]) VALUES (1, N'user', N'ggg')
INSERT [dbo].[role] ([role_id], [name], [description]) VALUES (2, N'admin', N'hhh')
SET IDENTITY_INSERT [dbo].[role] OFF
SET IDENTITY_INSERT [dbo].[room] ON 

INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (1, 1)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (2, 1)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (3, 2)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (4, 2)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (5, 3)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (6, 4)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (7, 3)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (8, 4)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (9, 5)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (10, 5)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (11, 6)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (12, 6)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (13, 7)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (14, 7)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (22, 9)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (23, 9)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (24, 10)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (25, 10)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (26, 11)
INSERT [dbo].[room] ([room_id], [room_type_id]) VALUES (27, 11)
SET IDENTITY_INSERT [dbo].[room] OFF
SET IDENTITY_INSERT [dbo].[room_type] ON 

INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (1, N'Single', N'The single room in our hotel is a cozy and well-appointed space designed for the comfort and convenience of solo travelers. Featuring a comfortable and inviting bed, the room is tastefully decorated with modern furnishings and thoughtful amenities. ', 40, 1, 50)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (2, N'Double', N'Our double room at the hotel is a spacious and inviting haven, thoughtfully designed to accommodate two guests in comfort and style. Furnished with a choice of either a king-size or twin beds, the room exudes a warm and contemporary ambiance. ', 45, 2, 100)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (3, N'Triple', N'Our triple room at the hotel is a spacious and versatile accommodation option designed to cater to the needs of groups or families traveling together. Thoughtfully appointed with a combination of a king-size bed and an additional single bed, this room offers a comfortable and welcoming environment for up to three guests.', 65, 3, 150)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (4, N'Quad', N'Our quad room at the hotel is a spacious and flexible haven, meticulously crafted to cater to the needs of groups or families of up to four individuals. With a combination of a generous king-size bed and two additional single beds, this room provides a comfortable and inviting space for shared experiences without compromising the personal space of each guest.', 75, 4, 200)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (5, N'Queen', N'The queen room at our hotel is a charming and intimate space designed for a luxurious and cozy stay. With a regal queen-size bed as the centerpiece, the room exudes a sense of elegance and comfort.', 50, 3, 120)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (6, N'King', N'Indulge in the ultimate luxury with our king room at the hotel—an opulent haven designed for discerning travelers seeking both comfort and sophistication. Centered around a lavish king-size bed, the room is adorned with tasteful decor and modern furnishings, creating an ambiance of refined elegance.', 50, 3, 130)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (7, N'Twin', N'Discover comfort and versatility in our twin room at the hotel, a thoughtfully designed space tailored for guests seeking the perfect balance between intimacy and independence. ', 40, 4, 145)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (9, N'President Suite', N'Indulge in the epitome of luxury with our President Suite at the hotel—an exclusive and opulent retreat designed for the most discerning guests. This expansive suite transcends traditional accommodation, featuring a master bedroom with a king-size bed, a separate living area, a private dining space, and a well-appointed kitchenette.', 350, 1, 5000)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (10, N'Apartments ', N'Welcome to our Apartments at the hotel, a unique and flexible accommodation option for guests seeking an extended stay or a home-like atmosphere. These spacious and well-appointed units feature a separate bedroom, a fully equipped kitchen, and a cozy living area, providing all the comforts of home in a hotel setting.', 250, 2, 1000)
INSERT [dbo].[room_type] ([room_type_id], [room_type_name], [description], [size], [capacity], [price]) VALUES (11, N'Connecting rooms', N'Experience the convenience and flexibility of our Connecting Rooms at the hotel, designed to cater to the needs of families, groups, or travelers seeking interconnected spaces. These rooms seamlessly combine comfort and privacy, offering the perfect solution for those who desire proximity while maintaining individual spaces.', 50, 6, 2400)
SET IDENTITY_INSERT [dbo].[room_type] OFF
SET IDENTITY_INSERT [dbo].[user] ON 

INSERT [dbo].[user] ([user_id], [name], [dob], [phone_number], [email]) VALUES (1, N'Duy An', NULL, NULL, NULL)
INSERT [dbo].[user] ([user_id], [name], [dob], [phone_number], [email]) VALUES (3, N'Lê Bình', CAST(N'2023-12-09' AS Date), N'234234', N'binh@gmail.com')
INSERT [dbo].[user] ([user_id], [name], [dob], [phone_number], [email]) VALUES (6, N'Mohas', CAST(N'2023-12-20' AS Date), N'456', N'anbatocom@gmail.com')
INSERT [dbo].[user] ([user_id], [name], [dob], [phone_number], [email]) VALUES (7, N'Đào An', NULL, NULL, NULL)
INSERT [dbo].[user] ([user_id], [name], [dob], [phone_number], [email]) VALUES (8, N'Tavo', CAST(N'2023-12-08' AS Date), N'234234234', N'tavo@gmail.com')
SET IDENTITY_INSERT [dbo].[user] OFF
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [FK_account_role] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([role_id])
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [FK_account_role]
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD  CONSTRAINT [FK_account_user1] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([user_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[account] CHECK CONSTRAINT [FK_account_user1]
GO
ALTER TABLE [dbo].[images]  WITH CHECK ADD  CONSTRAINT [FK_images_room_type] FOREIGN KEY([room_type_id])
REFERENCES [dbo].[room_type] ([room_type_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[images] CHECK CONSTRAINT [FK_images_room_type]
GO
ALTER TABLE [dbo].[occupied_room]  WITH CHECK ADD  CONSTRAINT [FK_occupied_room_reservation] FOREIGN KEY([reservation_id])
REFERENCES [dbo].[reservation] ([reservation_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[occupied_room] CHECK CONSTRAINT [FK_occupied_room_reservation]
GO
ALTER TABLE [dbo].[occupied_room]  WITH CHECK ADD  CONSTRAINT [FK_occupied_room_room] FOREIGN KEY([room_id])
REFERENCES [dbo].[room] ([room_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[occupied_room] CHECK CONSTRAINT [FK_occupied_room_room]
GO
ALTER TABLE [dbo].[reservation]  WITH CHECK ADD  CONSTRAINT [FK_reservation_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[user] ([user_id])
GO
ALTER TABLE [dbo].[reservation] CHECK CONSTRAINT [FK_reservation_user]
GO
ALTER TABLE [dbo].[reserved_room]  WITH CHECK ADD  CONSTRAINT [FK_reserved_room_reservation] FOREIGN KEY([reservation_id])
REFERENCES [dbo].[reservation] ([reservation_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[reserved_room] CHECK CONSTRAINT [FK_reserved_room_reservation]
GO
ALTER TABLE [dbo].[reserved_room]  WITH CHECK ADD  CONSTRAINT [FK_reserved_room_room_type] FOREIGN KEY([room_type_id])
REFERENCES [dbo].[room_type] ([room_type_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[reserved_room] CHECK CONSTRAINT [FK_reserved_room_room_type]
GO
ALTER TABLE [dbo].[room]  WITH CHECK ADD  CONSTRAINT [FK_room_room_type] FOREIGN KEY([room_type_id])
REFERENCES [dbo].[room_type] ([room_type_id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[room] CHECK CONSTRAINT [FK_room_room_type]
GO
